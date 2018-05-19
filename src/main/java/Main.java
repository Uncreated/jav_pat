public class Main {
    public static void main(String[] args) {
        //homework3();

        //homework4();

        homework5();
    }

    /*private static void homework3() {
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
    }*/

    private static void homework4() {
        //Composite
        Manager manager = Manager.getInstance();

        ExpenditureItem item1 = new ExpenditureItem(333.0f);
        ExpenditureItem item2 = new ExpenditureItem(444.0f);
        ExpenditureItem item3 = new ExpenditureItem(555.0f);

        manager.addCashAction(new CashIncome(1000));
        manager.addCashAction(new Expenditure().addItems(item1, item2));
        manager.addCashAction(new CashIncome(100));
        manager.addCashAction(new Expenditure().addItems(item2, item3));
        manager.addCashAction(new CashIncome(10));

        manager.print();

        System.out.println(manager.getTotal());
    }

    private static void mainSleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }

    private static void homework5() {
        mainSleep(5);
        Manager manager = Manager.getInstance();
        manager.loadFromDb();
        mainSleep(10);
    }
}
