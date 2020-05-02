package org.masterserver.service;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PlayerModel;

public interface PlayerService extends CommonService<PlayerModel> {

	PlayerModel getByUuid(String uuid);
	PlayerModel getByName(String name);
	List<PlayerModel> getByPrefix(String prefix);
	List<PlayerModel> getByNameColor(String name);
	List<PlayerModel> getByNameFormat(String nameFormat);
	List<PlayerModel> getByPrefixColor(String prefixColor);
	List<PlayerModel> getByPrefixFormat(String prefixFormat);
	List<PlayerModel> getByFirstLogin(Calendar firstLogin);
	List<PlayerModel> getByLastLogin(Calendar lastLogin);
	List<PlayerModel> getByTimePlayed(long timePlayed);
	
}