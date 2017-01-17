package by.beer.entities.beeritem.beerdata;

/**
 * Class {@code ChemicalComponentsComposition} includes all infrormation about
 * chemical elent's capacity at a {@code BeerItem} object.
 * 
 * @author Dmitry Zyablov
 *
 */
public class ChemicalComponentsComposition {

	private int waterСapacity;
	private int sugarСapacity;
	private int hopСapacity;
	private int maltСapacity;
	private int yeastСapacity;

	public ChemicalComponentsComposition() {
		this.waterСapacity = 0;
		this.sugarСapacity = 0;
		this.hopСapacity = 0;
		this.maltСapacity = 0;
		this.yeastСapacity = 0;
	}

	/**
	 * @param waterСapacity
	 * @param sugarСapacity
	 * @param hopСapacity
	 * @param maltСapacity
	 * @param yeastСapacity
	 */
	public ChemicalComponentsComposition(int waterСapacity, int sugarСapacity, int hopСapacity, int maltСapacity,
			int yeastСapacity) {
		this.waterСapacity = waterСapacity;
		this.sugarСapacity = sugarСapacity;
		this.hopСapacity = hopСapacity;
		this.maltСapacity = maltСapacity;
		this.yeastСapacity = yeastСapacity;
	}

	public int getWaterСapacity() {
		return waterСapacity;
	}

	public void setWaterСapacity(int waterСapacity) {
		this.waterСapacity = waterСapacity;
	}

	public int getSugarСapacity() {
		return sugarСapacity;
	}

	public void setSugarСapacity(int sugarСapacity) {
		this.sugarСapacity = sugarСapacity;
	}

	public int getHopСapacity() {
		return hopСapacity;
	}

	public void setHopСapacity(int hopСapacity) {
		this.hopСapacity = hopСapacity;
	}

	public int getMaltСapacity() {
		return maltСapacity;
	}

	public void setMaltСapacity(int maltСapacity) {
		this.maltСapacity = maltСapacity;
	}

	public int getYeastСapacity() {
		return yeastСapacity;
	}

	public void setYeastСapacity(int yeastСapacity) {
		this.yeastСapacity = yeastСapacity;
	}

	@Override
	public String toString() {
		return "ChemicalComponentsComposition [waterСapacity=" + waterСapacity + ", sugarСapacity=" + sugarСapacity
				+ ", hopСapacity=" + hopСapacity + ", maltСapacity=" + maltСapacity + ", yeastСapacity=" + yeastСapacity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hopСapacity;
		result = prime * result + maltСapacity;
		result = prime * result + sugarСapacity;
		result = prime * result + waterСapacity;
		result = prime * result + yeastСapacity;
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
		ChemicalComponentsComposition other = (ChemicalComponentsComposition) obj;
		if (hopСapacity != other.hopСapacity)
			return false;
		if (maltСapacity != other.maltСapacity)
			return false;
		if (sugarСapacity != other.sugarСapacity)
			return false;
		if (waterСapacity != other.waterСapacity)
			return false;
		if (yeastСapacity != other.yeastСapacity)
			return false;
		return true;
	}

}
