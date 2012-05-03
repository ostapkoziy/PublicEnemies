package com.epam.publicenemies.dto;

import java.io.Serializable;

import com.epam.publicenemies.domain.User;

/**
 * Prototype of user 
 * Updated by I. Kostyrko on 30.04.12: 
 * 		add constructor, money field, getter and setter
 * 
 */
public class UserDto implements Serializable {
	private static final long	serialVersionUID	= -5337809704733811878L;
	private int	userId; 
	private String email;
	// not sure we need this
	private String password;
	
	private int money; 
	private String nickName;
	private String avatar;
	
	/**
	 * By default
	 */
	public UserDto() {}
	
	/**
	 * Constructs object based on User object
	 * @param pUser
	 */
	public UserDto(User pUser) {
		this.userId = pUser.getUserId();
		this.email = pUser.getEmail();
		this.password = pUser.getPassword();
		this.money = pUser.getMoney();
		this.nickName = pUser.getNickName();
		this.avatar = pUser.getAvatar();
	}
	
	public String getEmail()	{
		return email;
	}
	public String getPassword()	{
		return password;
	}
	public void setEmail(String email)	{
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password)	{
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
