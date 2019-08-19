package services;

import entity.Operation;

import java.util.List;

public interface OperationService {
    public List<Operation> findOperation();
    public void insertOperation(Operation operation);
    public List<Operation> findByOpe(String ope);
}
