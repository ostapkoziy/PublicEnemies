package com.epam.publicenemies.dto;

import java.io.Serializable;

public class UserDto implements Serializable
{
	private static final long	serialVersionUID	= -5337809704733811878L;
	private int	id;
	private String email;
	private String password;
	private String nickName;
	private String avatar;
	public int getId()
	{
		return id;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getNickName() {
		return nickName;
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
