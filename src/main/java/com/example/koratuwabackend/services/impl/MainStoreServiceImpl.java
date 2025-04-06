package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.MainStore;
import com.example.koratuwabackend.repositories.MainStoreRepository;
import com.example.koratuwabackend.services.MainStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MainStoreServiceImpl implements MainStoreService {

    @Autowired
    private MainStoreRepository mainStoreRepository;

    @Override
    @CacheEvict(value = {
            "mainStores",
            "mainStoresByTypeIn",
            "mainStoresByTypeOut",
            "mainStoresByTypeInOut",
            "mainStoresNonEmptyTypeIn"
    }, allEntries = true)
    public MainStore saveMainStore(MainStore mainStore) {
        log.info("[cache:clear] -> All related caches evicted after saving MainStore: {}", mainStore.getId());
        MainStore saved = mainStoreRepository.save(mainStore);
        log.info("[db:save] -> MainStore saved: {}", saved.getId());
        return saved;
    }

    @Override
    @Cacheable("mainStores")
    public List<MainStore> getAllMainStores() {
        log.info("[cache:miss] -> Fetching all main stores from DB...");
        List<MainStore> stores = mainStoreRepository.findAll();
        log.info("[db:load] -> Found {} main stores", stores.size());
        return stores;
    }

    @Override
    @Cacheable("mainStoresNonEmptyTypeIn")
    public List<MainStore> getMainStoresWithNonEmptyStockSpicesTypeIn() {
        log.info("[cache:miss] -> Fetching main stores where stockSpicesTypeIn is not empty...");
        List<MainStore> stores = mainStoreRepository.findByStockSpicesTypeInIsNotEmpty();
        log.info("[db:load] -> Found {} main stores with non-empty typeIn", stores.size());
        return stores;
    }

    @Override
    @Cacheable(value = "mainStoresByTypeIn", key = "#stockSpicesTypeIn")
    public List<MainStore> getMainStoresByStockSpicesTypeIn(String stockSpicesTypeIn) {
        log.info("[cache:miss] -> Fetching main stores with typeIn = '{}'", stockSpicesTypeIn);
        return mainStoreRepository.findByStockSpicesTypeIn(stockSpicesTypeIn);
    }

    @Override
    @Cacheable(value = "mainStoresByTypeOut", key = "#stockSpicesTypeOut")
    public List<MainStore> getMainStoresByStockSpicesTypeOut(String stockSpicesTypeOut) {
        log.info("[cache:miss] -> Fetching main stores with typeOut = '{}'", stockSpicesTypeOut);
        return mainStoreRepository.findByStockSpicesTypeOut(stockSpicesTypeOut);
    }

    @Override
    @Cacheable(value = "mainStoresByTypeInOut", key = "#stockSpicesTypeIn + '_' + #stockSpicesTypeOut")
    public List<MainStore> getMainStoresByStockSpicesTypeInAndStockSpicesTypeOut(String stockSpicesTypeIn, String stockSpicesTypeOut) {
        log.info("[cache:miss] -> Fetching main stores with typeIn = '{}' and typeOut = '{}'", stockSpicesTypeIn, stockSpicesTypeOut);
        return mainStoreRepository.findByStockSpicesTypeInAndStockSpicesTypeOut(stockSpicesTypeIn, stockSpicesTypeOut);
    }


}