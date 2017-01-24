package by.beer.entities.beeritem.beerdata.chars;

import by.beer.entities.beeritem.BeerItem;

/**
 * Class {@code СharacteristiсData} provides production technologies's
 * information about {@code BeerItem} class.
 * 
 * @author Dmitry Zyablov
 * 
 * 
 * @see BeerItem
 *
 * 
 */
public abstract class СharacteristiсData {

	/**
	 * A clarity value of a beer
	 */
	private int beerClarity;

	/**
	 * This field provides is beer is filtered
	 */
	private boolean isFiltered;

	/**
	 * A value of calories in beer
	 */
	private float foodValue;

	/**
	 * This filed provides infromation about beer's package
	 */
	private PackageType packageType;

	/**
	 * 
	 */
	public СharacteristiсData() {
		this.beerClarity = 0;
		this.isFiltered = false;
		this.foodValue = 0;
		this.packageType = null;
	}

	/**
	 * @param alcoholVolume
	 * @param beerClarity
	 * @param isFiltered
	 * @param foodValue
	 */
	public СharacteristiсData(int beerClarity, boolean isFiltered, float foodValue, PackageType packageType) {
		this.beerClarity = beerClarity;
		this.isFiltered = isFiltered;
		this.foodValue = foodValue;
		this.packageType = packageType;
	}

	/**
	 * @return the beerClarity
	 */
	public int getBeerClarity() {
		return beerClarity;
	}

	public void setBeerClarity(int beerClarity) {
		this.beerClarity = beerClarity;
	}

	public boolean isFiltered() {
		return isFiltered;
	}

	public void setFiltered(boolean isFiltered) {
		this.isFiltered = isFiltered;
	}

	public float getFoodValue() {
		return foodValue;
	}

	public void setFoodValue(float foodValue) {
		this.foodValue = foodValue;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

	@Override
	public String toString() {
		return "СharacteristiсData [beerClarity=" + beerClarity + ", isFiltered=" + isFiltered + ", foodValue="
				+ foodValue + ", packageType=" + packageType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beerClarity;
		result = prime * result + Float.floatToIntBits(foodValue);
		result = prime * result + (isFiltered ? 1231 : 1237);
		result = prime * result + ((packageType == null) ? 0 : packageType.hashCode());
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
		СharacteristiсData other = (СharacteristiсData) obj;
		if (beerClarity != other.beerClarity)
			return false;
		if (Float.floatToIntBits(foodValue) != Float.floatToIntBits(other.foodValue))
			return false;
		if (isFiltered != other.isFiltered)
			return false;
		if (packageType == null) {
			if (other.packageType != null)
				return false;
		} else if (!packageType.equals(other.packageType))
			return false;
		return true;
	}

}
