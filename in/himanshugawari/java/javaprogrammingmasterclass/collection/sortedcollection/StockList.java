package in.himanshugawari.java.javaprogrammingmasterclass.collection.sortedcollection;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author himanshu
 *
 */
public class StockList {
	private final Map<String, StockItem> list;

	public StockList() {
		super();
		// HashMap is unordered
		// this.list = new HashMap<>();
		// LinkedHashMap is ordered
		this.list = new LinkedHashMap<String, StockItem>();
	}

	public int addItem(StockItem item) {
		if (item != null) {
			// check if already have quantities of this item
			StockItem inStock = list.getOrDefault(item.getName(), item);
			// if there are already stock on this item, adjust the qauantity
			if (inStock != item) {
				item.adjustQuantityStock(inStock.quantityInStock());
			}
			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		return 0;
	}

	public int sellStock(String item, int quantiy) {
		StockItem inStock = list.getOrDefault(item, null);
		if ((inStock != null) && (inStock.quantityInStock() >= quantiy) && (quantiy > 0)) {
			inStock.adjustQuantityStock(-quantiy);
			return quantiy;
		}
		return 0;
	}

	public StockItem get(String key) {
		return list.get(key);
	}

	public Map<String, StockItem> Items() {
		return Collections.unmodifiableMap(list);
	}

//	@Override
//	public String toString() {
//		return "StockList [list=" + list + ", toString()=" + super.toString() + "]";
//	}

	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for (Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}

		return s + "total stock value " + totalCost;
	}

}