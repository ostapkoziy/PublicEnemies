package com.epam.publicenemies.domain;

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
	private String avatar;
	private int money; 
	private int characterId;

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
			int money, String avatar, int userChar) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.money = money; 
		this.avatar = avatar;
		this.characterId = userChar;
	}
	
	/* 
	 * Old code 
	 * could be dangerous. Necessary data might be lost. 
	 * Use the biggest constructor or constructor by default  
	public User(int id, String email, String password) {
		//super();
		this.userId = id;
		this.email = email;
		this.password = password;
		avatar = new String();
	}	
	public User (int userId, String email, String password, String nickName) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		avatar = new String();
	}
	public User (int userId, String email, String password, String nickName, String avatar) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.avatar = avatar;
	} */
	

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
}