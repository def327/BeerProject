package by.beer.entities.beeritem.beerdata;

/**
 * Class {@code TradeBrandBeerdata} includes information about trandmark, beer's
 * name and sort of beer for {@code BeerItem} class.
 *
 * @author Дмитрий
 * 
 * @see by.beer.entities.beeritem.BeerItem
 *
 */
public class TradeBrandBeerdata {

	/**
	 * A name of beer product
	 */
	private String beerName;

	/**
	 * A name of manufacturer, which makes this beer
	 */
	private String manufacturerBeerName;

	/**
	 * A sort of the beer
	 */
	private String sortBeerType;

	/**
	 * 
	 */
	public TradeBrandBeerdata() {
		this.beerName = null;
		this.manufacturerBeerName = null;
		this.sortBeerType = null;
	}

	/**
	 * @param beerName
	 * @param manufacturerBeerName
	 * @param sortBeerType
	 */
	public TradeBrandBeerdata(String beerName, String manufacturerBeerName, String sortBeerType) {
		this.beerName = beerName;
		this.manufacturerBeerName = manufacturerBeerName;
		this.sortBeerType = sortBeerType;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public String getManufacturerBeerName() {
		return manufacturerBeerName;
	}

	public void setManufacturerBeerName(String manufacturerBeerName) {
		this.manufacturerBeerName = manufacturerBeerName;
	}

	public String getSortBeerType() {
		return sortBeerType;
	}

	public void setSortBeerType(String sortBeerType) {
		this.sortBeerType = sortBeerType;
	}

}
