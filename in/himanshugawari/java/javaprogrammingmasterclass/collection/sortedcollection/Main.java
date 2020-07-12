package in.himanshugawari.java.javaprogrammingmasterclass.collection.sortedcollection;

/**
 * @author himanshu
 *
 */
public class Main {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {

		StockItem temp = new StockItem("bread", 0.86, 100);
		stockList.addItem(temp);

		temp = new StockItem("cake", 1.10, 7);
		stockList.addItem(temp);

		temp = new StockItem("car", 12.50, 2);
		stockList.addItem(temp);

		temp = new StockItem("chair", 62.0, 10);
		stockList.addItem(temp);

		temp = new StockItem("cup", 0.50, 200);
		stockList.addItem(temp);
		temp = new StockItem("cup", 0.45, 7);
		stockList.addItem(temp);

		temp = new StockItem("door", 72.95, 4);
		stockList.addItem(temp);

		temp = new StockItem("juice", 2.50, 36);
		stockList.addItem(temp);

		temp = new StockItem("phone", 96.99, 35);
		stockList.addItem(temp);

		temp = new StockItem("towel", 2.40, 80);
		stockList.addItem(temp);

		temp = new StockItem("vase", 8.76, 40);
		stockList.addItem(temp);

		System.out.println(stockList);

		stockList.Items().keySet().forEach(key -> System.out.println(key));
	}
}