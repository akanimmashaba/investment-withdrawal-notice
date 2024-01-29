package com.enviro.assessment.grad001.akanimashaba.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.enviro.assessment.grad001.akanimashaba.model.Statement;
import com.enviro.assessment.grad001.akanimashaba.repository.StatementRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StatementService {
    @Autowired
    private StatementRepository statementRepository;

    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    public Optional<Statement> getStatementById(Long statementId) {
        return statementRepository.findById(statementId);
    }

    public Statement createStatement(Statement statement) {
        // Additional validation or business logic can be added here
        return statementRepository.save(statement);
    }

    public Statement updateStatement(Long statementId, Statement updatedStatement) {
        // Additional validation or business logic can be added here
        return statementRepository.findById(statementId)
                .map(existingStatement -> {
                    existingStatement.setStartDate(updatedStatement.getStartDate());
                    existingStatement.setEndDate(updatedStatement.getEndDate());
                    // Set other fields as needed
                    return statementRepository.save(existingStatement);
                })
                .orElse(null);
    }

    public void deleteStatement(Long statementId) {
        statementRepository.deleteById(statementId);
    }
}
