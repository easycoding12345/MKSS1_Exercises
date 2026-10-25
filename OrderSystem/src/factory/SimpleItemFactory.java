package factory;

import model.Product;
import model.Service;

public class SimpleItemFactory {
    public Product createProduct(String name, int unitPrice, int quantity) {
        return new Product(name, unitPrice, quantity);
    }
    //orderService has access to this instead of having access directly to service
    public Service createService(String name, int persons, int hours) {
        return new Service(name, persons, hours);
    }
}
