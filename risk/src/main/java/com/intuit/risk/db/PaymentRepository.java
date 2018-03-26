package com.intuit.risk.db;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    public List<Payment> findByUserId(String userId);

}
