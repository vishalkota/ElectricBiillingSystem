package com.meterbilling.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MeterBillingDetails")
public class MeterBilling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Long customerId; // Reference to user
    private String meterNumber;
    private double previousMonthReading;
    private double presentMonthReading;
    private double unitsConsumed;
    private double amount;
    private LocalDate billingDate;
    private String status;
    private double getMeterReading;

    // Default constructor
    public MeterBilling() {
    }

    // Constructor for creating a new MeterBilling record
    public MeterBilling(Long customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
        this.billingDate = LocalDate.now(); // Set current date as billing date
        this.status = "DUE"; // Default status
    }

    // Full constructor
    public MeterBilling(Long billId, Long customerId, String meterNumber, double previousMonthReading,
                        double presentMonthReading, double amount, LocalDate billingDate, String status) {
        this.billId = billId;
        this.customerId = customerId;
        this.meterNumber = meterNumber;
        this.previousMonthReading = previousMonthReading;
        this.presentMonthReading = presentMonthReading;
        this.unitsConsumed = presentMonthReading - previousMonthReading; // Calculate units consumed
        this.amount = amount;
        this.billingDate = billingDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public double getPreviousMonthReading() {
        return previousMonthReading;
    }

    public void setPreviousMonthReading(double previousMonthReading) {
        this.previousMonthReading = previousMonthReading;
    }

    public double getPresentMonthReading() {
        return presentMonthReading;
    }

    public void setPresentMonthReading(double presentMonthReading) {
        this.presentMonthReading = presentMonthReading;
        this.unitsConsumed = presentMonthReading - this.previousMonthReading; // Update units consumed
    }

    public double getUnitsConsumed() {
        return unitsConsumed; // Already calculated
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getGetMeterReading() {
        return getMeterReading;
    }

    public void setGetMeterReading(double getMeterReading) {
        this.getMeterReading = getMeterReading;
    }
}
