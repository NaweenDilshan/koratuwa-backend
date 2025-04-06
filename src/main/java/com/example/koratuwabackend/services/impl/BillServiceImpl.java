package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.Bill;
import com.example.koratuwabackend.repositories.BillRepository;
import com.example.koratuwabackend.services.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    @CacheEvict(value = "bills", allEntries = true)
    public Bill saveBill(Bill bill) {
        log.info("🧾 Saving new bill: {}", bill);
        Bill saved = billRepository.save(bill);
        log.info("🧹 Cache 'bills' cleared after saving.");
        return saved;
    }

    @Override
    @Cacheable("bills")
    public List<Bill> getAllBills() {
        log.info("📦 Fetching bills from DB (cache miss).");
        List<Bill> bills = billRepository.findAll();
        log.info("📦 Bills fetched: count = {}", bills.size());
        return bills;
    }
}

