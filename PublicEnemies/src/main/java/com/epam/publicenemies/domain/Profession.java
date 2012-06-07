package com.epam.publicenemies.domain;

public class Profession {

	private byte professionId;
	private String professionName;
	private String professionAvatar;
	
	public Profession() {
		professionId = 1;
		professionName = "Butcher";
		professionAvatar = "./img/avatars/default.png";
	}
	
	public Profession(byte professionId, String professionName, String professionAvatar) {
		this.professionId = professionId;
		this.professionName = professionName;
		this.professionAvatar = professionAvatar;
	}
	
	public byte getProfessionId() {
		return professionId;
	}
	public void setProfessionId(byte professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getProfessionAvatar() {
		return professionAvatar;
	}
	public void setProfessionAvatar(String professionAvatar) {
		this.professionAvatar = professionAvatar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((professionAvatar == null) ? 0 : professionAvatar.hashCode());
		result = prime * result + professionId;
		result = prime * result
				+ ((professionName == null) ? 0 : professionName.hashCode());
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
		Profession other = (Profession) obj;
		if (professionAvatar == null) {
			if (other.professionAvatar != null)
				return false;
		} else if (!professionAvatar.equals(other.professionAvatar))
			return false;
		if (professionId != other.professionId)
			return false;
		if (professionName == null) {
			if (other.professionName != null)
				return false;
		} else if (!professionName.equals(other.professionName))
			return false;
		return true;
	}
}
