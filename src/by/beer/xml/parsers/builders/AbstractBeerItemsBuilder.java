
package by.beer.xml.parsers.builders;

import java.util.ArrayList;
import java.util.List;

import by.beer.entities.beeritem.BeerItem;

/**
 * Class {@code AbstractBeerItemsBuilder} provides method to create a list of
 * {@code BeerItem} objects.
 * 
 * @author Дмитрий Зяблов
 * 
 * @see BeerItem
 *
 */
public abstract class AbstractBeerItemsBuilder {

	/**
	 * A list of {@code BeerItem} objects.
	 */
	protected List<BeerItem> beerItems;

	/**
	 * Constructs a default <code>AbstractBeerItemsBuilder</code>
	 */
	public AbstractBeerItemsBuilder() {
		beerItems = new ArrayList<BeerItem>();
	}

	/**
	 * Constructs a <code>AbstractBeerItemsBuilder</code> based on field.
	 * 
	 * @param beerItems
	 *            - a list of {@code BeerItem} objects
	 */
	public AbstractBeerItemsBuilder(List<BeerItem> beerItems) {
		this.beerItems = beerItems;
	}

	public List<BeerItem> getHumanEatings() {
		return beerItems;
	}

	/**
	 * Return's a list of {@code BeerItem} objects with initialized fields
	 * 
	 * @param fileName
	 *            - a path to xml document with {@code BeerItem} objects
	 * 
	 * @return a list of {@code BeerItem} object's
	 * 
	 */
	abstract public List<BeerItem> buildListBeerItems(String fileName);

}
