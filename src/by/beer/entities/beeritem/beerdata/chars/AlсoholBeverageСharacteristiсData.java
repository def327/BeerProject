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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "AlсoholBeverageСharacteristiсData [alcoholVolume=" + alcoholVolume + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(alcoholVolume);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlсoholBeverageСharacteristiсData other = (AlсoholBeverageСharacteristiсData) obj;
		if (Float.floatToIntBits(alcoholVolume) != Float.floatToIntBits(other.alcoholVolume))
			return false;
		return true;
	}

}
