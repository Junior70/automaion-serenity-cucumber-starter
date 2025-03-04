package starter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Barrista {
    public List<String> getPeningOrders() {
        List<String> results =  new ArrayList<>();
        results.add("large cappuccino");
        return results;
    }

    public List<String> getUrgentOrders() {
        List<String> results =  new ArrayList<>();
        results.add("Urgent");
        return results;
    }
}
