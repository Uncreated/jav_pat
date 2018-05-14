public class CashIncome extends CashAction {

    private float money;

    public CashIncome(float money) {
        this.money = money;
    }

    @Override
    public float getTotalSum() {
        return money;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("money={" + money + "}");
        return builder.toString();
    }
}
