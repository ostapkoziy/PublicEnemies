package com.epam.publicenemies.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.publicenemies.domain.fight.Level;

/**
 * God like Profile object. Contains all information about registered user
 * 
 * @author Chetyrkin S.V.
 */
public class Profile
{
	private Logger						log	= Logger.getLogger(Profile.class);
	private User						pUser;
	private UCharacter					pCharacter;
	private Armor						pArmor;
	private Aid							pAid;
	private Weapon						pWeapon1;
	private Weapon						pWeapon2;
	private HashMap<Integer, TrunkItem>	weapons;
	private HashMap<Integer, TrunkItem>	aids;
	private HashMap<Integer, TrunkItem>	armors;
	/**
	 * Default Profile constructor
	 */
	public Profile()
	{
		pUser = new User();
		pCharacter = new UCharacter();
		pArmor = new Armor();
		pAid = new Aid();
		pWeapon1 = new Weapon();
		pWeapon2 = new Weapon();
		weapons = new HashMap<Integer, TrunkItem>();
		aids = new HashMap<Integer, TrunkItem>();
		armors = new HashMap<Integer, TrunkItem>();
	}
	/**
	 * Non-default Profile constructor
	 * 
	 * @param user
	 *            - User Object
	 * @param character
	 *            - uCharacter object
	 */
	public Profile(User user, UCharacter character)
	{
		this.pUser = user;
		this.pCharacter = character;
		pArmor = new Armor();
		pAid = new Aid();
		pWeapon1 = new Weapon();
		pWeapon2 = new Weapon();
		weapons = new HashMap<Integer, TrunkItem>();
		aids = new HashMap<Integer, TrunkItem>();
		armors = new HashMap<Integer, TrunkItem>();
	}
	/**
	 * Get ArrayList of character's all weapons
	 * 
	 * @return ArrayList of character's all weapons
	 */
	public ArrayList<TrunkItem> getListOfWeapons()
	{
		return new ArrayList<TrunkItem>(weapons.values());
	}
	/**
	 * Get ArrayList of character's all armors
	 * 
	 * @return ArrayList of character's all armors
	 */
	public ArrayList<TrunkItem> getListOfArmors()
	{
		return new ArrayList<TrunkItem>(armors.values());
	}
	/**
	 * Get ArrayList of character's all aids
	 * 
	 * @return ArrayList of character's all aids
	 */
	public ArrayList<TrunkItem> getListOfAids()
	{
		return new ArrayList<TrunkItem>(aids.values());
	}
	/**
	 * Get all ArraylList of all undressed weapons
	 * 
	 * @return ArraylList of all undressed weapons
	 */
	public ArrayList<Weapon> getUndresedWeapons()
	{
		ArrayList<Weapon> arr = new ArrayList<Weapon>();
		for (TrunkItem t : this.getListOfWeapons())
		{
			if (!t.isWearing()) arr.add((Weapon) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all ArraylList of all undressed armors
	 * 
	 * @return ArraylList of all undressed armors
	 */
	public ArrayList<Armor> getUndressedArmors()
	{
		ArrayList<Armor> arr = new ArrayList<Armor>();
		for (TrunkItem t : this.getListOfArmors())
		{
			if (!t.isWearing()) arr.add((Armor) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all ArraylList of all undressed aids
	 * 
	 * @return ArraylList of all undressed aids
	 */
	public ArrayList<Aid> getUndressedAids()
	{
		ArrayList<Aid> arr = new ArrayList<Aid>();
		for (TrunkItem t : this.getListOfAids())
		{
			if (!t.isWearing()) arr.add((Aid) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all ArraylList of all dressed weapons
	 * 
	 * @return ArraylList of all dressed weapons
	 */
	public ArrayList<Weapon> getDresedWeapons()
	{
		ArrayList<Weapon> arr = new ArrayList<Weapon>();
		for (TrunkItem t : this.getListOfWeapons())
		{
			if (t.isWearing()) arr.add((Weapon) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all ArraylList of all dressed armors
	 * 
	 * @return ArraylList of all dressed armors
	 */
	public ArrayList<Armor> getDressedArmors()
	{
		ArrayList<Armor> arr = new ArrayList<Armor>();
		for (TrunkItem t : this.getListOfArmors())
		{
			if (t.isWearing()) arr.add((Armor) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all ArraylList of all dressed aids
	 * 
	 * @return ArraylList of all dressed aids
	 */
	public ArrayList<Aid> getDressedAids()
	{
		ArrayList<Aid> arr = new ArrayList<Aid>();
		for (TrunkItem t : this.getListOfAids())
		{
			if (t.isWearing()) arr.add((Aid) t.getItem());
		}
		return arr;
	}
	/**
	 * Get all weapons that are not dressed
	 * 
	 * @return amount of undressed weapons
	 */
	public int getUndressedWeaponsAmount()
	{
		int i = 0;
		for (TrunkItem t : this.getListOfWeapons())
		{
			if (!t.isWearing()) i++;
		}
		return i;
	}
	/**
	 * Get amount of undressed armors
	 * 
	 * @return amount of undressed armors
	 */
	public int getUndressedArmorsAmount()
	{
		int i = 0;
		for (TrunkItem t : this.getListOfArmors())
		{
			if (!t.isWearing())
			{
				i++;
			}
		}
		return i;
	}
	/**
	 * Get amount of undressed aids
	 * 
	 * @return amount of undressed aids
	 */
	public int getUndressedAidsAmount()
	{
		int i = 0;
		for (TrunkItem t : this.getListOfAids())
		{
			if (!t.isWearing()) i++;
		}
		return i;
	}
	/**
	 * Get all weapons
	 * 
	 * @return all character's weapons
	 */
	public HashMap<Integer, TrunkItem> getWeapons()
	{
		return weapons;
	}
	/**
	 * Set all weapons
	 * 
	 * @param weapons
	 *            - map of all weapons
	 */
	public void setWeapons(HashMap<Integer, TrunkItem> weapons)
	{
		this.weapons = weapons;
	}
	/**
	 * Get all character's aids
	 * 
	 * @return all characters aids
	 */
	public HashMap<Integer, TrunkItem> getAids()
	{
		return aids;
	}
	/**
	 * Set character's aids
	 * 
	 * @param aids
	 *            - map of all character aids
	 */
	public void setAids(HashMap<Integer, TrunkItem> aids)
	{
		this.aids = aids;
	}
	/**
	 * Get all character armors
	 * 
	 * @return all character armors
	 */
	public HashMap<Integer, TrunkItem> getArmors()
	{
		return armors;
	}
	/**
	 * Set all character's armors
	 * 
	 * @param armors
	 *            - map of all character armors
	 */
	public void setArmors(HashMap<Integer, TrunkItem> armors)
	{
		this.armors = armors;
	}
	/**
	 * Set dressed armor
	 * 
	 * @param armor
	 *            - Armor object
	 */
	public void setDressedArmor(Armor armor)
	{
		pArmor = armor;
	}
	/**
	 * Set Dressed Aid
	 * 
	 * @param aid
	 *            - Aid object
	 */
	public void setDressedAid(Aid aid)
	{
		pAid = aid;
	}
	/**
	 * Set first dressed Weapon
	 * 
	 * @param weapon
	 *            - Weapon object
	 */
	public void setDressedWeapon1(Weapon weapon)
	{
		pWeapon1 = weapon;
	}
	/**
	 * Set second dressed Weapon
	 * 
	 * @param weapon
	 *            - Weapon object
	 */
	public void setDressedWeapon2(Weapon weapon)
	{
		pWeapon2 = weapon;
	}
	/**
	 * Fill map of weapons in trunk
	 * 
	 * @param keys
	 *            - id's of injection in trunk table
	 * @param uWeapons
	 *            - Weapon objects from trunk
	 */
	public void fillWeaponsMap(List<Integer> keys, List<Weapon> uWeapons)
	{
		for (int i = 0; i < keys.size(); i++)
			putWeapon(keys.get(i), uWeapons.get(i));
		log.info("weapons map filled");
	}
	/**
	 * Fill map of aids in trunk
	 * 
	 * @param keys
	 *            - id's of injection in trunk table
	 * @param uWeapons
	 *            - Aid objects from trunk
	 */
	public void fillAidsMap(List<Integer> keys, List<Aid> uAids)
	{
		if (keys.size() == uAids.size())
		{
			for (int i = 0; i < keys.size(); i++)
			{
				putAid(keys.get(i), uAids.get(i));
			}
			log.info("aids map filled");
		}
		else
		{
			for (int i = 0; i < keys.size(); i++)
			{
				putAid(keys.get(i), uAids.get(i));
			}
			log.info("aids map not properly filled");
		}
	}
	/**
	 * Fill map of armors in trunk
	 * 
	 * @param keys
	 *            - id's of injection in trunk table
	 * @param uWeapons
	 *            - Armor objects from trunk
	 */
	public void fillArmorsMap(List<Integer> keys, List<Armor> uArmors)
	{
		if (keys.size() == uArmors.size())
		{
			for (int i = 0; i < keys.size(); i++)
				putArmor(keys.get(i), uArmors.get(i));
			log.info("armors map filled");
		}
		else
		{
			for (int i = 0; i < keys.size(); i++)
				putArmor(keys.get(i), uArmors.get(i));
			log.info("armors map not properly filled");
		}
	}
	public Weapon getDressedWeapon1()
	{
		return pWeapon1;
	}
	public Weapon getDressedWeapon2()
	{
		return pWeapon2;
	}
	public Armor getDressedArmor()
	{
		return pArmor;
	}
	public Aid getDressedAid()
	{
		return pAid;
	}
	/**
	 * Put Weapon in weapon map
	 * 
	 * @param id
	 *            - id of trunk table injection
	 * @param weapon
	 *            - Weapon object
	 */
	public void putWeapon(int id, Weapon weapon)
	{
		weapons.put(id, new TrunkItem(weapon));
	}
	/**
	 * Put Aid in aid map
	 * 
	 * @param id
	 *            - id of trunk table injection
	 * @param Aid
	 *            - Aid object
	 */
	public void putAid(int id, Aid aid)
	{
		aids.put(id, new TrunkItem(aid));
	}
	/**
	 * Put Armor in armor map
	 * 
	 * @param id
	 *            - id of trunk table injection
	 * @param armor
	 *            - Armor object
	 */
	public void putArmor(int id, Armor armor)
	{
		armors.put(id, new TrunkItem(armor));
	}
	/**
	 * Get Weapon object from weapon map
	 * 
	 * @param id
	 *            - Weapon object key
	 * @return - Weapon object
	 */
	public TrunkItem getTrunkWeapon(int id)
	{
		return weapons.get(id);
	}
	/**
	 * Get Aid object from aid map
	 * 
	 * @param id
	 *            - Aid object key
	 * @return - Aid object
	 */
	public TrunkItem getTrunkAid(int id)
	{
		return aids.get(id);
	}
	/**
	 * Get Armor object from armor map
	 * 
	 * @param id
	 *            - Armor object key
	 * @return - Armor object
	 */
	public TrunkItem getTrunkArmor(int id)
	{
		return armors.get(id);
	}
	/**
	 * Get id of user
	 * 
	 * @return - id of user
	 */
	public int getUserId()
	{
		return pUser.getUserId();
	}
	/**
	 * Set id of user
	 * 
	 * @param userId
	 *            - user id
	 */
	public void setUserId(int userId)
	{
		pUser.setUserId(userId);
	}
	/**
	 * Get user's sex. If true - male, else female
	 * 
	 * @return - user's sex
	 */
	public boolean isSex()
	{
		return pCharacter.isSex();
	}
	/**
	 * Set user's sex. If male - true, else false.
	 * 
	 * @param sex
	 *            - sex of user
	 */
	public void setSex(boolean sex)
	{
		pCharacter.setSex(sex);
	}
	/**
	 * Get amount of user's money.
	 * 
	 * @return - amount of money
	 */
	public int getMoney()
	{
		return pUser.getMoney();
	}
	/**
	 * Set amount of user's money
	 * 
	 * @param money
	 *            - amount of money
	 */
	public void setMoney(int money)
	{
		pUser.setMoney(money);
	}
	/**
	 * Get user's experience
	 * 
	 * @return - user experience
	 */
	public int getExperience()
	{
		return pCharacter.getExperience();
	}
	/**
	 * Set user's experience
	 * 
	 * @param experience
	 *            - user experience
	 */
	public void setExperience(int experience)
	{
		pCharacter.setExperience(experience);
	}
	/**
	 * Get user's strength
	 * 
	 * @return - amount of user's strength
	 */
	public int getStrength()
	{
		return pCharacter.getStrength();
	}
	/**
	 * Set user's strength
	 * 
	 * @param strength
	 *            - amount of user's strength
	 */
	public void setStrength(int strength)
	{
		pCharacter.setStrength(strength);
	}
	/**
	 * Get user's agility
	 * 
	 * @return amount of user's agility
	 */
	public int getAgility()
	{
		return pCharacter.getAgility();
	}
	/**
	 * Set user's agility
	 * 
	 * @param agility
	 *            - amount of user's agility
	 */
	public void setAgility(int agility)
	{
		pCharacter.setAgility(agility);
	}
	/**
	 * Get user's intellect
	 * 
	 * @return - amount of user's intellect
	 */
	public int getIntellect()
	{
		return pCharacter.getIntellect();
	}
	/**
	 * Set user's intellect
	 * 
	 * @param intellect
	 *            - amount of user's intellect
	 */
	public void setIntellect(int intellect)
	{
		pCharacter.setIntellect(intellect);
	}
	/**
	 * Get id of first dressed weapon
	 * 
	 * @return - id of weapon
	 */
	public int getWeapon1Id()
	{
		return pWeapon1.getItemId();
	}
	/**
	 * Set id of first dressed weapon
	 * 
	 * @param weapon1Id
	 *            - id of weapon
	 */
	public void setWeapon1Id(int weaponId)
	{
		pWeapon1.setItemId(weaponId);
	}
	/**
	 * Get id of second dressed weapon
	 * 
	 * @return - id of weapon
	 */
	public int getWeapon2Id()
	{
		return pWeapon2.getItemId();
	}
	/**
	 * Set id of second dressed weapon
	 * 
	 * @param weapon1Id
	 *            - id of weapon
	 */
	public void setWeapon2Id(int weaponId)
	{
		pWeapon2.setItemId(weaponId);
	}
	/**
	 * Get id of dressed armor
	 * 
	 * @return - id of armor
	 */
	public int getArmorId()
	{
		return pArmor.getItemId();
	}
	/**
	 * Set id of dressed armor
	 * 
	 * @param armorId
	 *            - id of armor
	 */
	public void setArmorId(int armorId)
	{
		pArmor.setItemId(armorId);
	}
	/**
	 * Get Id of dressed aid
	 * 
	 * @return - id of aid
	 */
	public int getAidId()
	{
		return pAid.getItemId();
	}
	/**
	 * Set id of dressed armor
	 * 
	 * @param aidId
	 *            - id of aid
	 */
	public void setAidId(int aidId)
	{
		pAid.setItemId(aidId);
	}
	/**
	 * Get id of user's character
	 * 
	 * @return - id of user's character
	 */
	public int getProfileId()
	{
		return pUser.getCharacterId();
	}
	/**
	 * Set id of user's character
	 * 
	 * @param profileId
	 *            - id of user's character
	 */
	public void setProfileId(int profileId)
	{
		pUser.getCharacterId();
	}
	/**
	 * Get nick name of user
	 * 
	 * @return - nick name of user
	 */
	public String getNickName()
	{
		return pUser.getNickName();
	}
	/**
	 * Set nick name of user
	 * 
	 * @param nickName
	 *            - nick name of user
	 */
	public void setNickName(String nickName)
	{
		pUser.setNickName(nickName);
	}
	/**
	 * Get picture of user's avatar
	 * 
	 * @return - path to image
	 */
	public String getAvatar()
	{
		return pUser.getAvatar();
	}
	/**
	 * Set picture avatar picture
	 * 
	 * @param avatar
	 *            - path to image
	 */
	public void setAvatar(String avatar)
	{
		pUser.setAvatar(avatar);
	}
	/**
	 * Get character's profession
	 * 
	 * @return character's profession
	 */
	public String getProfession()
	{
		return pCharacter.getProfession();
	}
	/**
	 * Set profession of character
	 * 
	 * @param profession
	 *            - name of profession
	 */
	public void setProfession(String profession)
	{
		pCharacter.setProffesion(profession);
	}
	/**
	 * Get amount of all fights
	 * 
	 * @return - amount of all fights
	 */
	public int getFightsTotal()
	{
		return pCharacter.getFightsTotal();
	}
	/**
	 * Set amount of all fights
	 * 
	 * @param fightsTotal
	 *            - amount of all fights
	 */
	public void setFightsTotal(int fightsTotal)
	{
		pCharacter.setFightsTotal(fightsTotal);
	}
	/**
	 * Get amount of won fights
	 * 
	 * @return - amount of won fights
	 */
	public int getFightsWon()
	{
		return pCharacter.getFightsWon();
	}
	/**
	 * Set amount of won fights
	 * 
	 * @param fightsWon
	 *            - amount of won fights
	 */
	public void setFightsWon(int fightsWon)
	{
		pCharacter.setFightsWon(fightsWon);
	}
	/**
	 * 
	 * @return character HP
	 */
	public int getHP()
	{
		return pCharacter.getHP();
	}
	/**
	 * 
	 * @param hp
	 *            - character HP
	 */
	public void setHP(int hp)
	{
		pCharacter.setHP(hp);
	}
	public int getAllHP()
	{
		return pCharacter.getAllUserHP();
	}
	public void setAllHP(int hp)
	{
		pCharacter.setAllUserHP(hp);
	}
	public int getDamage()
	{
		return pCharacter.getDamage();
	}
	public int getDefence()
	{
		return pCharacter.getDefence();
	}
	public Level getLevel()
	{
		return pCharacter.getLevel();
	}
	public void setDamage(int damage)
	{
		pCharacter.setDamage(damage);
	}
	public void setDefence(int defence)
	{
		pCharacter.setDefence(defence);
	}
	public void setLevel(Level level)
	{
		pCharacter.setLevel(level);
	}
	public String getEmail()
	{
		return pUser.getEmail();
	}
	public Timestamp getRegDate()
	{
		return pUser.getRegDate();
	}
}
