package utility;

import factory.SimpleItemFactory;
import services.OrderService;

public class OrderSystemMain {
	public static void main(String[] args) {
		SimpleItemFactory factory = new SimpleItemFactory();
		OrderService orderService = new OrderService();
		orderService.setFactory(factory);
		orderService.menuloop();
	}
}
