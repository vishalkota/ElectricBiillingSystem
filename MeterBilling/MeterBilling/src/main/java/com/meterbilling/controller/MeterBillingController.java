package com.meterbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meterbilling.entity.MeterBilling;

import com.meterbilling.service.MeterBillingService;


@RestController
@RequestMapping("/api/billing")
public class MeterBillingController {
	
	@Autowired
	 private MeterBillingService billingService;
	
	@PostMapping("/meter")
	public ResponseEntity<MeterBilling> createMeter(@RequestBody MeterBilling meter) {
		if (meter == null) {
			return ResponseEntity.badRequest().build();
			}
		MeterBilling createdMeter = billingService.createMeter(meter);
	       	return ResponseEntity.ok(createdMeter);
	    }
	
	
	
	 @GetMapping("/meter")
	    public ResponseEntity<MeterBilling> getMeter(@PathVariable String meterNumber) {
	        MeterBilling meter = billingService.getMeter(meterNumber);
	        if (meter == null) {
	            return ResponseEntity.notFound().build(); // Return 404 if meter is not found
	        }
	        return ResponseEntity.ok(meter);
	    }


	 
	 /*@PostMapping("/generatebill")
	 public ResponseEntity<MeterBilling> calculateBill(@RequestBody MeterBilling meterBilling) {
		 if (meterBilling == null || meterBilling.getMeterNumber() == null) {
		        return ResponseEntity.badRequest().body(null); // Return 400 if meterBilling or meterNumber is null
		    }

		    MeterBilling bill = billingService.generateBill(meterBilling);

		    if (bill == null) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 if bill generation fails
		    }

		    return ResponseEntity.ok(bill); 
	 }*/

	 
	 
}

