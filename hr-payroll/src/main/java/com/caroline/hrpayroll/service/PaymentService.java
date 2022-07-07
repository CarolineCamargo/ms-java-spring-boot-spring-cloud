package com.caroline.hrpayroll.service;

import com.caroline.hrpayroll.entity.Payment;
import com.caroline.hrpayroll.entity.Worker;
import com.caroline.hrpayroll.feingclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.getById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
