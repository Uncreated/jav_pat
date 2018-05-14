import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expenditure extends CashAction {

    private List<ExpenditureItem> items;

    public Expenditure() {
        items = new ArrayList<>();
    }

    public Expenditure addItems(ExpenditureItem... items) {
        this.items.addAll(Arrays.asList(items));
        return this;
    }

    @Override
    public float getTotalSum() {
        float total = 0;
        for (ExpenditureItem item : items) {
            total += item.getPrice();
        }
        return -total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("items={count=" + items.size() + ", total=" + getTotalSum() + "}");
        return builder.toString();
    }
}
