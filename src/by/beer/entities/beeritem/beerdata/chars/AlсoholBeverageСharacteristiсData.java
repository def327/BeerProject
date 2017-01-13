/**
 * 
 */
package by.beer.entities.beeritem.beerdata.chars;

/**
 * Class {@code AlсoholBeverageСharacteristiсData} is a child of
 * {@code СharacteristiсData} class, that provides production technologies's
 * information about {@code BeerItem} class, which has an alcohol.
 * 
 * 
 * @author Дмитрий
 * 
 * @see СharacteristiсData
 *
 */
public class AlсoholBeverageСharacteristiсData extends СharacteristiсData {

	/**
	 * An alcohol volume vlaue in beer
	 */
	private float alcoholVolume;

	/**
	 * 
	 */
	public AlсoholBeverageСharacteristiсData() {
		super();
		this.alcoholVolume = 0;
	}

	/**
	 * @param beerClarity
	 * @param isFiltered
	 * @param foodValue
	 * @param packageType
	 */
	public AlсoholBeverageСharacteristiсData(int beerClarity, boolean isFiltered, float foodValue,
			PackageType packageType, float alcoholVolume) {
		super(beerClarity, isFiltered, foodValue, packageType);
		this.alcoholVolume = alcoholVolume;
	}

	public float getAlcoholVolume() {
		return alcoholVolume;
	}

	public void setAlcoholVolume(float alcoholVolume) {
		this.alcoholVolume = alcoholVolume;
	}

}
