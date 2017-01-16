package by.beer.entities.beeritem.beerdata.chars;

/**
 * Class {@code PackageType} provides information about beer package.
 * 
 * @author Дмитрий Зяблов
 *
 */
public class PackageType {

	/**
	 * Capacity of a beer's package
	 */
	private float packageCapacity;

	/**
	 * A type of a material for beer package
	 */
	private String packageMaterial;

	/**
	 * 
	 */
	public PackageType() {
		this.packageCapacity = 0;
		this.packageMaterial = null;
	}

	public PackageType(float packageCapacity, String packageMaterial) {
		this.packageCapacity = packageCapacity;
		this.packageMaterial = packageMaterial;
	}

	public float getPackageCapacity() {
		return packageCapacity;
	}

	public void setPackageCapacity(float packageCapacity) {
		this.packageCapacity = packageCapacity;
	}

	public String getPackageMaterial() {
		return packageMaterial;
	}

	public void setPackageMaterial(String packageMaterial) {
		this.packageMaterial = packageMaterial;
	}

	@Override
	public String toString() {
		return "PackageType [packageCapacity=" + packageCapacity + ", packageMaterial=" + packageMaterial + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(packageCapacity);
		result = prime * result + ((packageMaterial == null) ? 0 : packageMaterial.hashCode());
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
		PackageType other = (PackageType) obj;
		if (Float.floatToIntBits(packageCapacity) != Float.floatToIntBits(other.packageCapacity))
			return false;
		if (packageMaterial == null) {
			if (other.packageMaterial != null)
				return false;
		} else if (!packageMaterial.equals(other.packageMaterial))
			return false;
		return true;
	}

}
