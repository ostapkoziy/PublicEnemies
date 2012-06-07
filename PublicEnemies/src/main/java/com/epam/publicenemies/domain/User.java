package com.epam.publicenemies.domain;

import java.sql.Timestamp;

/**
 * Represent user (the same way as 'users' table)
 * 
 * Updated by I. Kostyrko on 30.04.12
 */
public class User {

	private int userId;
	private String email;
	// not sure we need this
	private String password;	
	private String nickName;
	private String role;
	private String avatar;
	private int money; 
	private int characterId;
	private Timestamp regDate;

	public User() {
		email = new String();
		password = new String();
		nickName = new String();
		avatar = new String();
		money = 0; 
	}
	
	/**
	 * Inits all object fields with passed values
	 * DAO layer use this constructor 
	 * 
	 * TODO: table 'user' contains more fields. They may be added later
	 */
	public User(int userId, String email, String password, String nickName,
			int money, String avatar, int userChar, Timestamp regDate, String role) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.money = money; 
		this.avatar = avatar;
		this.characterId = userChar;
		this.regDate = regDate;
		this.role = role;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role; 
	}
	public void setRole(String role) {
		this.role = role; 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + characterId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + money;
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (characterId != other.characterId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (money != other.money)
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}