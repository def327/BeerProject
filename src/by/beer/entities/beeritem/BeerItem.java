package by.beer.entities.beeritem;

import by.beer.entities.beeritem.beerdata.ChemicalComponentsComposition;
import by.beer.entities.beeritem.beerdata.TradeBrandBeerdata;
import by.beer.entities.beeritem.beerdata.chars.СharacteristiсData;

/**
 * Class {@code BeerItem} desribes a beer {@code object} with features.
 * 
 * @author Дмитрий Зяблов
 *
 */
public class BeerItem {

	/**
	 * {@code BeerItem} object's unuqiue ID
	 */
	private int beerId;

	/**
	 * This field provides infromation about beer's brand company
	 */
	private TradeBrandBeerdata brandData;

	/**
	 * This field provides information about chemical element's capacity in beer
	 */
	private ChemicalComponentsComposition chemicalComposition;

	/**
	 * Is an alcohol in beer
	 */
	private String alcoholBeerType;

	/**
	 * Technology production information for beer
	 */
	private СharacteristiсData charsData;

	/**
	 * Constructs a default <code>BeerItem</code>
	 */
	public BeerItem() {
		this.beerId = 0;
		this.brandData = null;
		this.chemicalComposition = null;
		this.alcoholBeerType = null;
		this.charsData = null;
	}

	/**
	 * 
	 * Constructs a <code>BeerItem</code> based on fields.
	 * 
	 * @param beerId
	 *            - a unique ID of {@code BeerItem} object
	 * @param brandData
	 *            - a {@code TradeBrandBeerdata} object about compnay and beer
	 *            production name
	 * @param chemicalComposition
	 *            - a chemical element capacity in beer
	 * @param alcoholBeerType
	 *            - is an alcohol in beer
	 * @param charsData
	 *            - technology production information for beer
	 */
	public BeerItem(int beerId, TradeBrandBeerdata brandData, ChemicalComponentsComposition chemicalComposition,
			String alcoholBeerType, СharacteristiсData charsData) {
		this.beerId = beerId;
		this.brandData = brandData;
		this.chemicalComposition = chemicalComposition;
		this.alcoholBeerType = alcoholBeerType;
		this.charsData = charsData;
	}

	public int getBeerId() {
		return beerId;
	}

	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}

	public TradeBrandBeerdata getBrandData() {
		return brandData;
	}

	public void setBrandData(TradeBrandBeerdata brandData) {
		this.brandData = brandData;
	}

	public ChemicalComponentsComposition getChemicalComposition() {
		return chemicalComposition;
	}

	public void setChemicalComposition(ChemicalComponentsComposition chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}

	public String getAlcoholBeerType() {
		return alcoholBeerType;
	}

	public void setAlcoholBeerType(String alcoholBeerType) {
		this.alcoholBeerType = alcoholBeerType;
	}

	public СharacteristiсData getCharsData() {
		return charsData;
	}

	public void setCharsData(СharacteristiсData charsData) {
		this.charsData = charsData;
	}

	@Override
	public String toString() {
		return "BeerItem [beerId=" + beerId + ", brandData=" + brandData + ", chemicalComposition="
				+ chemicalComposition + ", alcoholBeerType=" + alcoholBeerType + ", charsData=" + charsData + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alcoholBeerType == null) ? 0 : alcoholBeerType.hashCode());
		result = prime * result + beerId;
		result = prime * result + ((brandData == null) ? 0 : brandData.hashCode());
		result = prime * result + ((charsData == null) ? 0 : charsData.hashCode());
		result = prime * result + ((chemicalComposition == null) ? 0 : chemicalComposition.hashCode());
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
		BeerItem other = (BeerItem) obj;
		if (alcoholBeerType == null) {
			if (other.alcoholBeerType != null)
				return false;
		} else if (!alcoholBeerType.equals(other.alcoholBeerType))
			return false;
		if (beerId != other.beerId)
			return false;
		if (brandData == null) {
			if (other.brandData != null)
				return false;
		} else if (!brandData.equals(other.brandData))
			return false;
		if (charsData == null) {
			if (other.charsData != null)
				return false;
		} else if (!charsData.equals(other.charsData))
			return false;
		if (chemicalComposition == null) {
			if (other.chemicalComposition != null)
				return false;
		} else if (!chemicalComposition.equals(other.chemicalComposition))
			return false;
		return true;
	}

}
