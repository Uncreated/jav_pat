import java.util.Date;

public abstract class CashAction {

    private User user;
    private Date date;

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract float getTotalSum();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (user != null) {
            builder.append("User={" + user.toString() + "}\n");
        }
        if (date != null) {
            builder.append("Date={" + date.toString() + "}\n");
        }
        return builder.toString();
    }
}
