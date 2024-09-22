package com.meterbilling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meterbilling.entity.MeterBilling;

@Repository
public interface MeterBillingRepository extends JpaRepository<MeterBilling,Long>{
	Optional<MeterBilling> findByMeterNumber(String meterNumber);

}
