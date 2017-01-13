/**
 * 
 */
package by.beer.xml.parsers.builders;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import by.beer.entities.beeritem.BeerItem;

/**
 * @author Дмитрий
 *
 */
public abstract class AbstractBeerItemsBuilder {

	protected List<BeerItem> beerItems;

	public AbstractBeerItemsBuilder() {
		beerItems = new ArrayList<BeerItem>();
	}

	/**
	 * @param humanEatings
	 */
	public AbstractBeerItemsBuilder(List<BeerItem> beerItems) {
		this.beerItems = beerItems;
	}

	public List<BeerItem> getHumanEatings() {
		return beerItems;
	}

	/**
	 * TODO В этом методе при переодпрделении создаёте объект !вашего парсера,
	 * здесь же вызываете его методы, парсите и на выходе отдаёте коллекцию с
	 * типом <beerItem> c инициализированными!!! полями
	 * 
	 * @param fileName
	 * @return
	 * @throws ParserConfigurationException
	 */
	abstract public List<BeerItem> buildListBeerItems(String fileName) throws ParserConfigurationException;

}
