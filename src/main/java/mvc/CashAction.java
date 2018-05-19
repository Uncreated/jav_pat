package mvc;

public class CashAction {

    private Long id;
    private String userName;
    private Float total;

    public CashAction() {
    }

    public CashAction(Long id, String userName, Float total) {
        this.id = id;
        this.userName = userName;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CashAction{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", total=" + total +
                '}';
    }
}
