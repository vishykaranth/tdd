package bdd.calculator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorSteps {
    private int firstNumber;
    private int secondNumber;
    private int addResult;

    @Then("^sum of two number should be (\\d+)$")
    public void sumOfTwoNumberShouldBe(int sum)  {
        assertThat(addResult, is(sum));
    }

    @Given("^that first number is (\\d+)$")
    public void thatFirstNumberIs(int firstNumber) throws Throwable {
        this.firstNumber = firstNumber;
    }

    @And("^the second number is (\\d+)$")
    public void theSecondNumberIs(int secondNumber) throws Throwable {
        this.secondNumber = secondNumber;
    }

    @When("^I add first and second number$")
    public void iAddFirstAndSecondNumber() throws Throwable {
        addResult = firstNumber + secondNumber;
    }
}
