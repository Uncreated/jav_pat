package mvc.controller;

import mvc.CashAction;
import mvc.model.DatabaseMapper;

public class Controller {
    private DatabaseMapper databaseMapper;

    public Controller(DatabaseMapper databaseMapper) {
        this.databaseMapper = databaseMapper;
    }

    public CashAction getCashAction(Long id) {
        return databaseMapper.getCashActionById(id);
    }
}
