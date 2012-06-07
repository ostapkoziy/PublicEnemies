package com.epam.publicenemies.domain;

/**
 * Item in trunk object
 * @author Chetyrkin S.V. 14.05.2012
 *
 */
public class TrunkItem {
	
	private Item item;
	private boolean wearing;
	
	/**
	 * Get item
	 * @return Item object
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Set Item in trunk
	 * @param item - Item object
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Get indication of wearing. If true item is wearing now.
	 * @return - indication of wearing
	 */
	public boolean isWearing() {
		return wearing;
	}
	
	/**
	 * Set indication of wearing
	 * @param wearing - indication of wearing 
	 */
	public void setWearing(boolean wearing) {
		this.wearing = wearing;
	}

	/**
	 * TrunkItem constructor. Wearing indication sets to false by default.
	 * @param item - item in trunk
	 */
	public TrunkItem(Item item) {
		wearing = false;
		this.item = item;
	}
	
	public TrunkItem() {
		item = new Item() {
		};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + (wearing ? 1231 : 1237);
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
		TrunkItem other = (TrunkItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (wearing != other.wearing)
			return false;
		return true;
	}
	
	
	
}
