package com.epam.publicenemies.service;

import com.epam.publicenemies.dto.StatsDto;
import com.epam.publicenemies.dto.UserDto;

/*
 * in profile service
 */
public interface IStatsManagerService {
	StatsDto saveStats(StatsDto statsDto,UserDto userDto);

	StatsDto getStatsByUser(UserDto userDto);
}
