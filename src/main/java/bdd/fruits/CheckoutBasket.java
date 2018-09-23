package bdd.fruits;

import java.util.HashMap;
import java.util.Map;

public class CheckoutBasket {
    Map<String, Integer> items = new HashMap();
    public void addItem(String fruitName, int quantity) {
        items.put(fruitName, quantity);
    }

    public int getQuantity(String fruitName){
        return items.get(fruitName);
    }
}
