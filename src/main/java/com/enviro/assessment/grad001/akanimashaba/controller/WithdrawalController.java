package com.enviro.assessment.grad001.akanimashaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.akanimashaba.model.WithdrawalNotice;
import com.enviro.assessment.grad001.akanimashaba.service.WithdrawalService;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {
    @Autowired
    private WithdrawalService withdrawalNoticeService;

    @GetMapping
    public ResponseEntity<List<WithdrawalNotice>> getAllWithdrawalNotices() {
        List<WithdrawalNotice> withdrawalNotices = withdrawalNoticeService.getAllWithdrawalNotices();
        return new ResponseEntity<>(withdrawalNotices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WithdrawalNotice> getWithdrawalNoticeById(@PathVariable Long id) {
        Optional<WithdrawalNotice> withdrawalNotice = withdrawalNoticeService.getWithdrawalNoticeById(id);
        return withdrawalNotice.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<WithdrawalNotice> createWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice) {
        WithdrawalNotice createdWithdrawalNotice = withdrawalNoticeService.createWithdrawalNotice(withdrawalNotice);
        return new ResponseEntity<>(createdWithdrawalNotice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WithdrawalNotice> updateWithdrawalNotice(@PathVariable Long id, @RequestBody WithdrawalNotice updatedWithdrawalNotice) {
        WithdrawalNotice updated = withdrawalNoticeService.updateWithdrawalNotice(id, updatedWithdrawalNotice);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWithdrawalNotice(@PathVariable Long id) {
        withdrawalNoticeService.deleteWithdrawalNotice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
