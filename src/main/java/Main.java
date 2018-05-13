import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Singleton
        Manager manager = Manager.getInstance();

        User user = new User();

        ExpenditureItem item1 = new ExpenditureItem(333.0f);
        ExpenditureItem item2 = new ExpenditureItem(444.0f);
        ExpenditureItem item3 = new ExpenditureItem(555.0f);

        //builder
        manager.addExpenditure(new Expenditure()
                .setUser(user)
                .setDate(new Date())
                .addItems(item1, item2));

        manager.addExpenditure(new Expenditure()
                .setUser(user)
                .setDate(new Date())
                .addItems(item2, item3));

        manager.print();
    }
}
