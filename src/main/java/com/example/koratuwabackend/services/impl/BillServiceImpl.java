package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.Bill;
import com.example.koratuwabackend.repositories.BillRepository;
import com.example.koratuwabackend.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
