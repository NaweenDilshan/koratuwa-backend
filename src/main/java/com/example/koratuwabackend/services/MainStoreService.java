package com.example.koratuwabackend.services;

import com.example.koratuwabackend.models.MainStore;
import java.util.List;

public interface MainStoreService {
    MainStore saveMainStore(MainStore mainStore);
    List<MainStore> getAllMainStores();
    List<MainStore> getMainStoresWithNonEmptyStockSpicesTypeIn();
    List<MainStore> getMainStoresByStockSpicesTypeIn(String stockSpicesTypeIn);
    List<MainStore> getMainStoresByStockSpicesTypeOut(String stockSpicesTypeOut);
    List<MainStore> getMainStoresByStockSpicesTypeInAndStockSpicesTypeOut(String stockSpicesTypeIn, String stockSpicesTypeOut);




}