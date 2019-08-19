package services.impl;

import entity.Operation;
import mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.OperationService;

import java.util.List;
@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationMapper operationMapper;
    @Override
    public List<Operation> findOperation() {
        return operationMapper.findOperation();
    }

    @Override
    public void insertOperation(Operation operation) {
        operationMapper.insertOperation(operation);
    }

    @Override
    public List<Operation> findByOpe(String ope) {
        return operationMapper.findByOpe(ope);
    }
}
