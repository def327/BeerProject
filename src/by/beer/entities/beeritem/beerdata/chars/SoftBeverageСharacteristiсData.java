package by.beer.entities.beeritem.beerdata.chars;

/**
 * Class {@code SoftBeverageСharacteristiсData} is a child of
 * {@code СharacteristiсData} class, that provides production technologies's
 * information about {@code BeerItem} class, which hasn't hava an alcohol.
 * 
 * 
 * @author Дмитрий
 * 
 * @see СharacteristiсData
 *
 */
public class SoftBeverageСharacteristiсData extends СharacteristiсData {

	/**
	 * 
	 */
	public SoftBeverageСharacteristiсData() {
		super();
	}

	/**
	 * @param beerClarity
	 * @param isFiltered
	 * @param foodValue
	 */
	public SoftBeverageСharacteristiсData(int beerClarity, boolean isFiltered, float foodValue,
			PackageType packageType) {
		super(beerClarity, isFiltered, foodValue, packageType);
	}

}
