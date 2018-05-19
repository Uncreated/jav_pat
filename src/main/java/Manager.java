import javafx.beans.InvalidationListener;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private static Manager ourInstance = new Manager();

    public static Manager getInstance() {
        return ourInstance;
    }

    private List<CashAction> cashActions;

    private Manager() {
        cashActions = new ArrayList<>();
    }

    public void addCashAction(CashAction cashAction) {
        cashActions.add(cashAction);
    }

    public float getTotal() {
        float total = 0;
        for (CashAction cashAction : cashActions) {
            total += cashAction.getTotalSum();
        }
        return total;
    }

    public void print() {
        for (CashAction cashAction : cashActions) {
            System.out.println(cashAction.toString());
            System.out.println();
        }
    }

    public void loadFromDb() {
        InvalidationListener listener = observable -> {

            Db db = (Db) observable;
            System.out.println("I got notify from DB");
            System.out.println("His data is " + db.getData());
        };
        Db.getInstance().addListener(listener);
    }
}
