package services;

import factory.SimpleItemFactory;
import model.Order;
import model.Orderable;
import model.Product;
import model.Service;
import utility.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService {

	private Order order = new Order();
    private SimpleItemFactory factory;
	private List<Orderable> orderables = new ArrayList<>();

    public void setFactory(SimpleItemFactory factory) {
        this.factory = factory;
    }

	public void menuloop() {
		int input;
		do {
			printMenu();
			input = Input.readInt();
			switch ( input ) {
				case 0: break ;
				case 1: orderProduct(); break ;
				case 2: orderService(); break ;
				default: System.out.println("invalid" ); break ;
			}
		} while( input != 0);
		sortOrderables();
		order.setLumpSumInCents(300);
		finishOrder() ;
	}
	
	private void printMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}
	
	private void sortOrderables() {
        orderables.sort(Comparator.comparingInt(Orderable::getPrice));
    }
	private void orderProduct() {
		System.out.println("Name: ");
		String productName  = Input.readString();
		System.out.println("Unit price (in cents): ");
		int unitPriceInCent = Input.readInt();
		System.out.println("Quantity: ");
		int quantity = Input.readInt();
        for (Orderable items : orderables){
            if (items instanceof Product product){
                if (product.getName() !=null &&
                productName !=null && product.getName().
                        equalsIgnoreCase(productName)
                        && product.getUnitPrice()== unitPriceInCent){
                    product.increaseQuantity(quantity);
                    return;
                }
            }
        }
        orderables.add(factory.createProduct(productName,
                unitPriceInCent, quantity));
	}
	
	private void orderService() {
		System.out.println("model.Service type: ");
		String seviceName = Input.readString();
		System.out.println("Number of persons: ");
		int persons = Input.readInt();
		System.out.println("Hours: ");
		int hours = Input.readInt();
        for (Orderable items : orderables){
            if (items instanceof Service service){
                if (service.getName() !=null &&
                        seviceName!=null && service.getName()
                        .equalsIgnoreCase(seviceName)
                        && service.getHours() == hours){
                    service.increasePersons(persons);
                    return;
                }
            }
        }
        orderables.add(factory.createService(seviceName,  persons, hours));
	}
	
	private void finishOrder() {
        int sum = 0;

        for (Orderable item : orderables) {
            if (item != null) {
                item.print();

                int price = item.getPrice();
                sum += price;

                System.out.print(" = " + formatPrice(price) + " EUR");
            }
        }
        int lumpSum = order.getLumpSumInCents();
        sum += lumpSum;
        System.out.println("Lump sum: " + formatPrice(lumpSum));
        System.out.println("Sum: " + formatPrice(sum) + " EUR");
        //date time records
        order.setCheckoutTime(java.time.LocalDateTime.now());
        System.out.println(
                "checkout time:" + order.getCheckoutTime()
        );
        // Start a new order
        order = new Order();
        orderables.clear();
    }
	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100;
	}
}
