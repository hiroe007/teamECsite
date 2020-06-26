package jp.co.internous.node.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.node.model.domain.MstDestination;
import jp.co.internous.node.model.domain.MstUser;
import jp.co.internous.node.model.form.DestinationForm;
import jp.co.internous.node.model.mapper.MstDestinationMapper;
import jp.co.internous.node.model.mapper.MstUserMapper;
import jp.co.internous.node.model.session.LoginSession;

@Controller
@RequestMapping("/node/destination")
public class DestinationController {

	@Autowired
	private MstUserMapper userMapper;

	@Autowired
	MstDestinationMapper destinationMapper;

	@Autowired
	private LoginSession loginSession;

	private Gson gson = new Gson();

	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);

		return "destination";
	}

//	delete
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map= gson.fromJson(destinationId, Map.class);
		String id=map.get("destinationId");
		
		long result=destinationMapper.logicalDeleteById(Long.parseLong(id));

		return result > 0;

	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {

//		宛先を登録
		MstDestination destination=new MstDestination(f);
		long userId=loginSession.getUserId();
		destination.setUserId(userId);
		long count = destinationMapper.insert(destination);


		// 登録した宛先のIDを取得
		Long id = (long) 0;
		if (count > 0) {
			id = destinationMapper.findIdByUserId(userId);
		}
		return id.toString();
	}

}
