package bdd.fruits;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vishwa on 6/13/2018.
 */
public class FruitSteps {

    FruitCatalogue catalogue = new FruitCatalogue();
    CheckoutBasket basket = new CheckoutBasket();


    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String fruitName, int price){
        catalogue.addFruitPrice(fruitName, price);
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int quantity, String fruitName){
        basket.addItem(fruitName, quantity);
    }

    @Then("^I should be charged (\\d+)c$")
    public void iShouldBeChargedC(int expectedChargeAmount){
        int chargeAmount = chargeAmount();
        assertThat(chargeAmount, is(expectedChargeAmount));
    }

    private int chargeAmount() {
        Iterator<String> iterator = catalogue.getCatalogue().keySet().iterator();
        int cost = 0;
        while(iterator.hasNext()){
            String fruit = iterator.next();

            int quantity = basket.getQuantity(fruit);
            int price = catalogue.getPrice(fruit);

            cost += (quantity * price);
        }
        return cost;
    }
}
