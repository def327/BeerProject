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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeBrandBeerdata [beerName=" + beerName + ", manufacturerBeerName=" + manufacturerBeerName
				+ ", sortBeerType=" + sortBeerType + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beerName == null) ? 0 : beerName.hashCode());
		result = prime * result + ((manufacturerBeerName == null) ? 0 : manufacturerBeerName.hashCode());
		result = prime * result + ((sortBeerType == null) ? 0 : sortBeerType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeBrandBeerdata other = (TradeBrandBeerdata) obj;
		if (beerName == null) {
			if (other.beerName != null)
				return false;
		} else if (!beerName.equals(other.beerName))
			return false;
		if (manufacturerBeerName == null) {
			if (other.manufacturerBeerName != null)
				return false;
		} else if (!manufacturerBeerName.equals(other.manufacturerBeerName))
			return false;
		if (sortBeerType == null) {
			if (other.sortBeerType != null)
				return false;
		} else if (!sortBeerType.equals(other.sortBeerType))
			return false;
		return true;
	}

}
