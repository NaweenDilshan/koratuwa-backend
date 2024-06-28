package com.example.koratuwabackend.controller;
import com.example.koratuwabackend.models.PackingStore;
import com.example.koratuwabackend.services.PackingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packing-store")
public class PackingStoreController {
    private final PackingStoreService packingStoreService;

    @Autowired
    public PackingStoreController(PackingStoreService packingStoreService) {
        this.packingStoreService = packingStoreService;
    }

    @PostMapping("/save")
    public ResponseEntity<PackingStore> savePackingStore(@RequestBody PackingStore packingStore) {
        PackingStore savedPackingStore = packingStoreService.savePackingStore(packingStore);
        return ResponseEntity.ok(savedPackingStore);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PackingStore>> getAllPackingStores() {
        List<PackingStore> packingStores = packingStoreService.getAllPackingStores();
        return ResponseEntity.ok(packingStores);
    }
}
