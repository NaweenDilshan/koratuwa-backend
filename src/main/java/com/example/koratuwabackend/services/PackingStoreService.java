package com.example.koratuwabackend.services;

import com.example.koratuwabackend.models.PackingStore;

import java.util.List;

public interface PackingStoreService {
    PackingStore savePackingStore(PackingStore packingStore);
    List<PackingStore> getAllPackingStores();
}
