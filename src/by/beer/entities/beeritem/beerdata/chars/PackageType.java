package by.beer.entities.beeritem.beerdata.chars;

/**
 * Class {@code PackageType} provides information about beer package.
 * 
 * @author Дмитрий
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

}
