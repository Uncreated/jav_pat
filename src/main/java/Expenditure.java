import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Expenditure {

    private User user;
    private Date date;

    private List<ExpenditureItem> items;

    public Expenditure() {
        items = new ArrayList<>();
    }

    public Expenditure setUser(User user) {
        this.user = user;
        return this;
    }

    public Expenditure setDate(Date date) {
        this.date = date;
        return this;
    }

    public Expenditure addItems(ExpenditureItem... items) {
        this.items.addAll(Arrays.asList(items));
        return this;
    }

    public float getTotal() {
        float total = 0;
        for (ExpenditureItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (user != null) {
            builder.append("User={" + user.toString() + "}\n");
        }
        if (date != null) {
            builder.append("Date={" + date.toString() + "}\n");
        }
        builder.append("items={count=" + items.size() + ", total=" + getTotal() + "}");
        return builder.toString();
    }
}
