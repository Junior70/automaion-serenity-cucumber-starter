package starter.screenplay.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {


    public static Performable toTheHomePage() {
        return Open.url("https://todomvc.com/examples/angularjs_require/#/");
    }
}
