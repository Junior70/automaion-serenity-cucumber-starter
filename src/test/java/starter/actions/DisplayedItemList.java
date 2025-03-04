package starter.actions;

import net.serenitybdd.core.pages.PageComponent;

import java.time.Duration;
import java.util.List;

public class DisplayedItemList extends PageComponent {
    public List<String> getDisplayedItems() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(".todo-list label");
        return $$(".todo-list label").texts();

        /*List<String> displayedItems = driver.findElements(By.cssSelector(".todo-list label"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        System.out.println("Esperado: " + todoItems);
        System.out.println("Obtenido: " + displayedItems);*/
    }
}
