package com.enviro.assessment.grad001.akanimashaba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enviro.assessment.grad001.akanimashaba.model.WithdrawalNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {

}
