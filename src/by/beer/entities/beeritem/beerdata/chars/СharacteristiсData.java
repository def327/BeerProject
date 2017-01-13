package by.beer.entities.beeritem.beerdata.chars;

/**
 * Class {@code СharacteristiсData} provides production technologies's
 * information about {@code BeerItem} class.
 * 
 * @author Дмитрий
 * 
 * @see by.beer.entities.beeritem.BeerItem
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

	public double getFoodValue() {
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

}
