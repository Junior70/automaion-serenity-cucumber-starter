package starter.screenplay.task;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class CurrentTodoItems {
    public static Question<Collection<String>> forThisActor() {
        return Text.ofEach(".todo-list label");
    }
}
