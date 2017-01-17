
package by.beer.entities.beeritem.manager;

import java.util.LinkedList;
import java.util.List;

import by.beer.entities.beeritem.BeerItem;

/**
 * Class {@code ManagerBeerItem} storages and manages the list of
 * {@code BeerItem} object.
 * 
 * @see BeerItem
 * 
 * @author Дмитри Зяблов
 * 
 */
public class ManagerBeerItem {

	/**
	 * The list of {@code BeerItem} objects.
	 */
	private List<BeerItem> listBeerItem;

	/**
	 * Returns a boolean value is a list of {@code BeerItem} object initialized.
	 * 
	 * @return a boolean value
	 */
	public boolean haveBeerItemObjects() {
		return (listBeerItem.size() != 0) ? true : false;
	}

	/**
	 * Constructs a <code>ManagerBeerItem</code> based on field.
	 * 
	 * @param listBeerItem
	 *            - a list of {@code BeerItem} objects.
	 */
	public ManagerBeerItem(List<BeerItem> listBeerItem) {
		this.listBeerItem = listBeerItem;
	}

	/**
	 * Constructs a default <code>ManagerBeerItem</code>
	 */
	public ManagerBeerItem() {
		this.listBeerItem = new LinkedList<>();
	}

	public List<BeerItem> getListBeerItem() {
		return listBeerItem;
	}

	public void setListBeerItem(List<BeerItem> listBeerItem) {
		this.listBeerItem = listBeerItem;
	}

}
