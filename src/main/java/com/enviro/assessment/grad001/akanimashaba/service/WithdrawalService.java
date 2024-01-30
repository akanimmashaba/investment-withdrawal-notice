package com.enviro.assessment.grad001.akanimashaba.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.enviro.assessment.grad001.akanimashaba.model.WithdrawalNotice;
import com.enviro.assessment.grad001.akanimashaba.repository.WithdrawalNoticeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {
    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    public List<WithdrawalNotice> getAllWithdrawalNotices() {
        return withdrawalNoticeRepository.findAll();
    }

    public Optional<WithdrawalNotice> getWithdrawalNoticeById(Long withdrawalNoticeId) {
        return withdrawalNoticeRepository.findById(withdrawalNoticeId);
    }

    public WithdrawalNotice createWithdrawalNotice(WithdrawalNotice withdrawalNotice) {
        // Additional validation or business logic can be added here
        return withdrawalNoticeRepository.save(withdrawalNotice);
    }

    public WithdrawalNotice updateWithdrawalNotice(Long withdrawalNoticeId, WithdrawalNotice updatedWithdrawalNotice) {
        // Additional validation or business logic can be added here
        return withdrawalNoticeRepository.findById(withdrawalNoticeId)
                .map(existingWithdrawalNotice -> {
                    existingWithdrawalNotice.setWithdrawalAmount(updatedWithdrawalNotice.getWithdrawalAmount());
                    existingWithdrawalNotice.setWithdrawalDate(updatedWithdrawalNotice.getWithdrawalDate());
                    existingWithdrawalNotice.setBankingDetails(updatedWithdrawalNotice.getBankingDetails());
                    existingWithdrawalNotice.setStatus(updatedWithdrawalNotice.getStatus());
                    return withdrawalNoticeRepository.save(existingWithdrawalNotice);
                })
                .orElse(null);
    }

    public void deleteWithdrawalNotice(Long withdrawalNoticeId) {
        withdrawalNoticeRepository.deleteById(withdrawalNoticeId);
    }

}
