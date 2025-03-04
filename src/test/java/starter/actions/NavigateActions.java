package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigateActions extends UIInteractionSteps {
    @Step("User opens the todo list aplication")
    public void toTheHomePage() {
        this.openUrl("https://todomvc.com/examples/angularjs_require/#/");
    }
}
