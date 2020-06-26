package jp.co.internous.node.model.domain;

import java.sql.Timestamp;
import jp.co.internous.node.model.form.DestinationForm;

public class MstDestination {

	private long id;
	private long userId;
	private String familyName;
	private String firstName;
	private String telNumber;
	private String address;
	private long status;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	

	public MstDestination() {
	}

	public MstDestination(DestinationForm f) {
		userId = f.getUserId();
		familyName = f.getFamilyName();
		firstName = f.getFirstName();
		telNumber = f.getTelNumber();
		address = f.getAddress();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}