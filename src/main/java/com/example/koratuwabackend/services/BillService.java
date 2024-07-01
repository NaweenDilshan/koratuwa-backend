package com.example.koratuwabackend.services;

import com.example.koratuwabackend.models.Bill;
import java.util.List;

public interface BillService {
    Bill saveBill(Bill bill);
    List<Bill> getAllBills();
}