package com.epam.publicenemies.dao;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;

public interface IProfileDao {
	/*Profile getProfileByUser(User user);*/

	void updateProfile(Profile profile);
	
	void updateProfile(int uid, String nickName, String avatar, boolean sex,
			String prof);
	
	void deleteProfile(Profile profile);
	
	User getUserById(int userId);

	UCharacter getCharacterByUserId(int userId);

	UCharacter getCharacterById(int characterId);
}
