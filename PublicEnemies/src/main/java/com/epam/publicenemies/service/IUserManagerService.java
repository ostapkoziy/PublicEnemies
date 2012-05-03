package com.epam.publicenemies.service;

import com.epam.publicenemies.dto.UserDto;

public interface IUserManagerService {
	UserDto registerNewUser(String uEmail, String uPasswd, String uNickName);

	UserDto findUserByEmail(String email);
	
	UserDto getUserByEmailAndPassword(String name, String password);
}
