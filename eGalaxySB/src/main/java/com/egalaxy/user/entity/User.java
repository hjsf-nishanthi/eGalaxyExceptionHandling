package com.egalaxy.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_EMAIL", length = 30)
	private String userEmail;
	//@Null(message = "Please provide the password")
	@Column(name = "USER_PASSWORD", length = 30)
	private String userPassword;
	@Column(name = "USER_DOB")
	private String userDob;
	@Column(name = "USER_GENDER")
	private String userGender;
	
	User() {
		
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDob() {
		return userDob;
	}

	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ",userEmail=" + userEmail + ", userName=" + userName + ", userPassword=" + userPassword + ", userDob="
				+ userDob + ", userGender=" + userGender + "]";
	}

	
}
