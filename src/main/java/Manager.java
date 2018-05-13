import java.util.ArrayList;
import java.util.List;

public class Manager {

    private static Manager ourInstance = new Manager();

    public static Manager getInstance() {
        return ourInstance;
    }

    private List<Expenditure> expenditures;

    private Manager() {
        expenditures = new ArrayList<>();
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }

    public void print() {
        for (Expenditure expenditure : expenditures) {
            System.out.println(expenditure.toString());
            System.out.println();
        }
    }
}
