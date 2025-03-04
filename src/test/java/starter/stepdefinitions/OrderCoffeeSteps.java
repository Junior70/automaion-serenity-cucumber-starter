package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import starter.Barrista;
import starter.Customer;

import static org.hamcrest.Matchers.hasItem;

public class OrderCoffeeSteps {

    Customer customer = new Customer();
    Barrista barry = new Barrista();
    String order;

    //@Given("^Junior is (\\d+) meters from  the coffee shop$")
    @Given("Junior is {int} meters from the coffee shop")
    public void junior_is_meters_from_the_coffee_shop(Integer distanceInMeters) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        customer.setDistanceFromShop(distanceInMeters);
    }

    //@When("Junior orders a large cappuccino")
    @When("^Junior orders a (.*)$")
    public void junior_orders_a(String orderedProduct) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        this.order = orderedProduct;
        customer.placeOrderFor(this.order);
    }

    @Then("Barry should receive the order")
    public void barry_should_receive_the_order() {
        Assert.assertTrue(barry.getPeningOrders().contains(order));
    }

    @Then("^Barry should know that the order is (.*)$")
    public void barry_should_know_that_the_order_is(String order) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(barry.getUrgentOrders().contains(order));

    }
}
