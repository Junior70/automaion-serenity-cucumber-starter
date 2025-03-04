package starter.stepdefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import starter.actions.DisplayedItemList;
import starter.screenplay.navigation.Navigate;
import starter.screenplay.task.AddATodoItem;
import starter.screenplay.task.CurrentTodoItems;

import java.util.Collection;
import java.util.List;

public class AddingTodoItemsStepsV2 {


    @Managed
    WebDriver driver;

    Actor actor;

    @BeforeAll
    public static void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor namedActor(String name) { // Nuevo nombre
        return OnStage.theActorCalled(name);
    }


    @Given("{actor} has an empty todo list new")
    public void actorHasAnEmptyTodoListNew(Actor actor) {
        actor.attemptsTo(Navigate.toTheHomePage());
    }

    @When("{actor} add new {string}")
    public void heAddNew(Actor actor, String todoItem) {
        actor.attemptsTo(AddATodoItem.called(todoItem));
    }

    @Then("{actor} should have the new")
    public void heShouldHaveTheNew(Actor actor, List<String> todoItems) {


        Collection<String> displayedItems = actor.asksFor(CurrentTodoItems.forThisActor());

        System.out.println("Esperado: " + todoItems);
        System.out.println("Obtenido: " + displayedItems);

        Assert.assertEquals("Los elementos mostrados no coinciden con los esperados", todoItems, displayedItems);
        Assert.assertTrue(displayedItems.containsAll(todoItems));
    }
}
