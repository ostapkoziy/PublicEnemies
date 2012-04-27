package com.epam.publicenemies.domain;

public class User {

	private int userId;
	private String email;
	private String password;
	private String nickName;
	private String avatar;
	private int characterId;

	public User() {
		email = new String();
		password = new String();
		nickName = new String();
		avatar = new String();
	}

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
	}

	public int getId() {
		return userId;
	}
	
	public void setId(int id) {
		this.userId = id;
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



	public int getCharacterId() {
		return characterId;
	}



	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
}