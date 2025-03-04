package starter.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;


public class AddATodoItem {
    private static Target NEW_TODO_ITEM = Target.the("new todo field").locatedBy(".new-todo");
    public static Performable called(String todoItem) {
        return Enter.theValue(todoItem).into(NEW_TODO_ITEM).thenHit(Keys.ENTER);
    }
}
