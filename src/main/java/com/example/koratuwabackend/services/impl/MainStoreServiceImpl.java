package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.MainStore;
import com.example.koratuwabackend.repositories.MainStoreRepository;
import com.example.koratuwabackend.services.MainStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainStoreServiceImpl implements MainStoreService {

    @Autowired
    private MainStoreRepository mainStoreRepository;

    @Override
    public MainStore saveMainStore(MainStore mainStore) {
        return mainStoreRepository.save(mainStore);
    }
    @Override
    public List<MainStore> getAllMainStores() {
        return mainStoreRepository.findAll();
    }
    @Override
    public List<MainStore> getMainStoresWithNonEmptyStockSpicesTypeIn() {
        return mainStoreRepository.findByStockSpicesTypeInIsNotEmpty();
    }
    @Override
    public List<MainStore> getMainStoresByStockSpicesTypeIn(String stockSpicesTypeIn) {
        return mainStoreRepository.findByStockSpicesTypeIn(stockSpicesTypeIn);
    }
    @Override
    public List<MainStore> getMainStoresByStockSpicesTypeOut(String stockSpicesTypeOut) {
        return mainStoreRepository.findByStockSpicesTypeOut(stockSpicesTypeOut);
    }
    @Override
    public List<MainStore> getMainStoresByStockSpicesTypeInAndStockSpicesTypeOut(String stockSpicesTypeIn, String stockSpicesTypeOut) {
        return mainStoreRepository.findByStockSpicesTypeInAndStockSpicesTypeOut(stockSpicesTypeIn, stockSpicesTypeOut);
    }


}