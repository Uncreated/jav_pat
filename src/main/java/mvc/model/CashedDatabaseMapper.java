package mvc.model;

import mvc.CashAction;

import java.util.HashMap;
import java.util.Map;

public class CashedDatabaseMapper implements DatabaseMapper {

    private Map<Long, CashAction> cashActions;
    private DatabaseMapper databaseMapper;

    public CashedDatabaseMapper(DatabaseSQLiteMapper databaseMapper) {
        this.cashActions = new HashMap<>();
        this.databaseMapper = databaseMapper;
    }

    @Override
    public CashAction getCashActionById(Long id) {
        CashAction cashAction = cashActions.get(id);
        if (cashAction == null) {
            cashAction = databaseMapper.getCashActionById(id);
            cashActions.put(id, cashAction);
        }
        return cashAction;
    }

    @Override
    public void addCashAction(CashAction cashAction) {
        cashActions.put(cashAction.getId(), cashAction);
        databaseMapper.addCashAction(cashAction);
    }
}
