package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.PackingStore;
import com.example.koratuwabackend.repositories.PackingStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PackingStoreServiceImpl implements PackingStoreService {
    private final PackingStoreRepository packingStoreRepository;

    @Autowired
    public PackingStoreServiceImpl(PackingStoreRepository packingStoreRepository) {
        this.packingStoreRepository = packingStoreRepository;
    }

    @Override
    public PackingStore savePackingStore(PackingStore packingStore) {
        return packingStoreRepository.save(packingStore);
    }

    @Override
    public List<PackingStore> getAllPackingStores() {
        return packingStoreRepository.findAll();
    }
}
