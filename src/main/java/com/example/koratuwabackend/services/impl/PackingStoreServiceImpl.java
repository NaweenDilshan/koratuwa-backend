package com.example.koratuwabackend.services.impl;

import com.example.koratuwabackend.models.PackingStore;
import com.example.koratuwabackend.repositories.PackingStoreRepository;
import com.example.koratuwabackend.services.PackingStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class PackingStoreServiceImpl implements PackingStoreService {

    private final PackingStoreRepository packingStoreRepository;

    @Autowired
    public PackingStoreServiceImpl(PackingStoreRepository packingStoreRepository) {
        this.packingStoreRepository = packingStoreRepository;
    }

    @Override
    @CacheEvict(value = "packingStores", allEntries = true)
    public PackingStore savePackingStore(PackingStore packingStore) {
        log.info("[cache:clear] -> Evicted 'packingStores' after saving new PackingStore: {}", packingStore.getId());
        PackingStore saved = packingStoreRepository.save(packingStore);
        log.info("[db:save] -> PackingStore saved: {}", saved.getId());
        return saved;
    }

    @Override
    @Cacheable("packingStores")
    public List<PackingStore> getAllPackingStores() {
        log.info("[cache:miss] -> Fetching all PackingStores from DB...");
        List<PackingStore> stores = packingStoreRepository.findAll();
        log.info("[db:load] -> Found {} PackingStores", stores.size());
        return stores;
    }
}
