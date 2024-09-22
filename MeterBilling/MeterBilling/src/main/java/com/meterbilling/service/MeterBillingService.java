package com.meterbilling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meterbilling.entity.MeterBilling;
import com.meterbilling.repository.MeterBillingRepository;

@Service
public class MeterBillingService {
    @Autowired
    private MeterBillingRepository meterBillingRepository; // Keeping only one repository
    
//    public MeterBilling getMeter(String meterNumber) {
//        return meterBillingRepository.findByMeterNumber(meterNumber)
//                .orElseThrow(() -> new RuntimeException("Meter not found"));
//    }
    public MeterBilling createMeter(MeterBilling meterBilling) {
        if (meterBilling == null) {
            throw new IllegalArgumentException("MeterBilling cannot be null");
        }
        // Additional validation can be added here
        return meterBillingRepository.save(meterBilling);
    }
    
    
    public MeterBilling getMeter(String meterNumber) {
        if (meterNumber == null || meterNumber.isEmpty()) {
            throw new IllegalArgumentException("Meter number cannot be null or empty");
        }
        
        return meterBillingRepository.findByMeterNumber(meterNumber)
                .orElseThrow(() -> new RuntimeException("Meter not found with number: " + meterNumber));
    }

   

//    public MeterBilling getMeter(String meterNumber) {
//        return meterBillingRepository.findByMeterNumber(meterNumber).orElse(null);
//    }
    

    
    
    


    
    
    
    public MeterBilling calculateBill(MeterBilling meterReading) {
        
            // Calculate bill amount based on units consumed
           double amount = calculateAmount(meterReading);
            Long customerId=meterReading.getCustomerId();
            MeterBilling bill = new MeterBilling(customerId, amount); // Ensure correct constructor exists
            meterBillingRepository.save(bill);
            return bill;
            
        
    }

    private double calculateAmount(MeterBilling meterReading) {
        // Implement tiered pricing system
        if (meterReading.getUnitsConsumed() <= 100) {
            return meterReading.getUnitsConsumed() * 3.10;
        } else if (meterReading.getUnitsConsumed() <= 200) {
            return meterReading.getUnitsConsumed() * 4.80;
        }
        else if (meterReading.getUnitsConsumed() <= 300) {
            return meterReading.getUnitsConsumed() * 5.10;
        }
        else {
            return meterReading.getUnitsConsumed() * 9.00;
        }
    }
    
    

	
}

