package mvc.model;

import mvc.CashAction;

public interface DatabaseMapper {

    CashAction getCashActionById(Long id);

    void addCashAction(CashAction cashAction);
}
