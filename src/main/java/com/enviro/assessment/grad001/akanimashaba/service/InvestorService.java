package com.enviro.assessment.grad001.akanimashaba.service;

import com.enviro.assessment.grad001.akanimashaba.model.Investor;
import com.enviro.assessment.grad001.akanimashaba.repository.InvestorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {
    @Autowired
    private InvestorRepository investorRepository;

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Optional<Investor> getInvestorById(Long investorId) {
        return investorRepository.findById(investorId);
    }

    public Investor createInvestor(Investor investor) {
        // Additional validation or business logic can be added here
        return investorRepository.save(investor);
    }

    public Investor updateInvestor(Long investorId, Investor updatedInvestor) {
        // Additional validation or business logic can be added here
        return investorRepository.findById(investorId)
                .map(existingInvestor -> {
                    existingInvestor.setFirstName(updatedInvestor.getFirstName());
                    existingInvestor.setLastName(updatedInvestor.getLastName());
                    existingInvestor.setEmail(updatedInvestor.getEmail());
                    existingInvestor.setAddress(updatedInvestor.getAddress());
                    existingInvestor.setContactNumber(updatedInvestor.getContactNumber());
                    existingInvestor.setAge(updatedInvestor.getAge());
                    return investorRepository.save(existingInvestor);
                })
                .orElse(null);
    }

    public void deleteInvestor(Long investorId) {
        investorRepository.deleteById(investorId);
    }

}
