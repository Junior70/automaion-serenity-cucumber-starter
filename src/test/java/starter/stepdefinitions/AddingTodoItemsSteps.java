package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.actions.AddItemActions;
import starter.actions.DisplayedItemList;
import starter.actions.NavigateActions;

import java.util.List;
import java.util.stream.Collectors;

public class AddingTodoItemsSteps {

    @Steps
    NavigateActions navigateActions;

    @Steps
    AddItemActions addItemActions;

    @Steps
    DisplayedItemList displayedItemList;

    /*WebDriver driver;

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
    }*/

    @Given("Toddhas an empty todo list")
    public void toddhasAnEmptyTodoList() {
        navigateActions.toTheHomePage();
        //driver.get("https://todomvc.com/examples/angularjs_require/#/");
    }

    @When("he add {string}")
    public void heAdd(String todoItem) {
        addItemActions.called(todoItem);
        //driver.findElement(By.cssSelector(".new-todo")).sendKeys(todoItem);
        //driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
    }

    @Then("he should have the")
    public void heShouldHaveThe(List<String> todoItems) throws InterruptedException {
        List<String> displayedItems = displayedItemList.getDisplayedItems();
        /*List<String> displayedItems = driver.findElements(By.cssSelector(".todo-list label"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());*/
        System.out.println("Esperado: " + todoItems);
        System.out.println("Obtenido: " + displayedItems);

        Assert.assertEquals("Los elementos mostrados no coinciden con los esperados", todoItems, displayedItems);
        Assert.assertTrue(displayedItems.containsAll(todoItems));
    }

    /*@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
