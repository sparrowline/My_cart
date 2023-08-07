package com.sr.mycart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this will generates the id in sequential order;
	private int userId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "userEmail", unique = true, nullable = false)
	private String userEmail;
	@Column(name = "userPassword")
	private String userPassword;
	@Column(name = "userPhone")
	private String userPhone;
	@Column(name = "userPic")
	private String userPic;
	@Column(length = 1500, name = "userAddress") 
	// this will defines the length of address and one more thing we can do
	// here is change the name of the column in db but not in java
	// variable
	private String userAddress;
	@Column(name = "userType",columnDefinition = "VARCHAR(255) default 'normal user'")
	private String userType="normal user";

	// generating constructor with all the parameters
	public User(int userId, String userName, String userEmail, String userPassword, String userPhone, String userPic,
			String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAddress = userAddress;
	}

	// constructor without using id(because it is auto incremented )
	public User(String userName, String userEmail, String userPassword, String userPhone, String userPic,
			String userAddress) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAddress = userAddress;
	}

//default constructor
	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userPic=" + userPic + ", userAddress=" + userAddress
				+ "]";
	}
//important method to whether the user is admin or normal user.?
	public boolean isAdmin() {
	    return "admin".equals(this.userType);
	}


}
