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

    @Autowired
    private InvestorService investorService;

    @Autowired
    private ProductService productService;

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

//    private void validateWithdrawalNotice(WithdrawalNotice withdrawalNotice) {
//        validateInvestorAgeForRetirementProduct(withdrawalNotice.getInvestorId(), withdrawalNotice.getProductId());
//        validateWithdrawalAmountVsBalance(withdrawalNotice.getProductId(), withdrawalNotice.getWithdrawalAmount());
//        validateWithdrawalAmountPercentage(withdrawalNotice.getProductId(), withdrawalNotice.getWithdrawalAmount());
//    }
//
//    private void validateInvestorAgeForRetirementProduct(Long investorId, Long productId) {
//        // Retrieve investor age based on investorId
//        int investorAge = investorService.getInvestorById(investorId);
//
//        // Retrieve product type based on productId
//        String productType = productService.getProductType(productId);
//
//        // Check if the product is of type "RETIREMENT" and investor age is greater than 65
//        if ("RETIREMENT".equals(productType) && investorAge <= 65) {
//            throw new ValidationException("Investor age must be greater than 65 for RETIREMENT products.");
//        }
//    }
//
//    private void validateWithdrawalAmountVsBalance(Long productId, Double withdrawalAmount) {
//        // Retrieve the current balance for the selected product
//        Double currentBalance = productService.getCurrentBalance(productId);
//
//        // Check if the withdrawal amount is greater than the current balance
//        if (withdrawalAmount > currentBalance) {
//            throw new ValidationException("Withdrawal amount cannot be greater than the current balance.");
//        }
//    }
//
//    private void validateWithdrawalAmountPercentage(Long productId, Double withdrawalAmount) {
//        // Retrieve the current balance for the selected product
//        Double currentBalance = productService.getCurrentBalance(productId);
//
//        // Check if the withdrawal amount is more than 90% of the current balance
//        double withdrawalPercentage = withdrawalAmount / currentBalance * 100;
//        if (withdrawalPercentage > 90) {
//            throw new ValidationException("Investors cannot withdraw an amount more than 90% of the current balance.");
//        }
//    }

}
