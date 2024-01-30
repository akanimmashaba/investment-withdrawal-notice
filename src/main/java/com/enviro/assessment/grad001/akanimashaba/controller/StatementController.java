package com.enviro.assessment.grad001.akanimashaba.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.akanimashaba.model.Statement;
import com.enviro.assessment.grad001.akanimashaba.service.StatementService;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/statements")
public class StatementController {
    @Autowired
    private StatementService statementService;

    @GetMapping
    public ResponseEntity<List<Statement>> getAllStatements() {
        List<Statement> statements = statementService.getAllStatements();
        return new ResponseEntity<>(statements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statement> getStatementById(@PathVariable Long id) {
        Optional<Statement> statement = statementService.getStatementById(id);
        return statement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Statement> createStatement(@RequestBody Statement statement) {
        Statement createdStatement = statementService.createStatement(statement);
        return new ResponseEntity<>(createdStatement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statement> updateStatement(@PathVariable Long id, @RequestBody Statement updatedStatement) {
        Statement updated = statementService.updateStatement(id, updatedStatement);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatement(@PathVariable Long id) {
        statementService.deleteStatement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
