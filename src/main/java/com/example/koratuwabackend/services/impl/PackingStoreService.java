package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.PackingStore;

import java.util.List;

public interface PackingStoreService {
    PackingStore savePackingStore(PackingStore packingStore);
    List<PackingStore> getAllPackingStores();
}
