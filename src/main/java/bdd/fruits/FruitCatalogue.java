package bdd.fruits;

import java.util.HashMap;
import java.util.Map;

public class FruitCatalogue {
    Map<String, Integer> catalogue = new HashMap();
    public void addFruitPrice(String fruitName, int price) {
        catalogue.put(fruitName, price);
    }

    public int getPrice(String fruitName){
        return catalogue.get(fruitName);
    }

    public Map<String, Integer> getCatalogue(){
        return catalogue;
    }
}
