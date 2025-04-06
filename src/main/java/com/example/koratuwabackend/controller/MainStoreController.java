package com.example.koratuwabackend.controller;

import com.example.koratuwabackend.models.MainStore;
import com.example.koratuwabackend.services.MainStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main-store")
public class MainStoreController {

    @Autowired
    private MainStoreService mainStoreService;

    @PostMapping("/save")
    public ResponseEntity<MainStore> saveMainStore(@RequestBody MainStore mainStore) {
        MainStore savedMainStore = mainStoreService.saveMainStore(mainStore);
        return ResponseEntity.ok(savedMainStore);
    }
    @GetMapping("/all")
    public ResponseEntity<List<MainStore>> getAllMainStores() {
        List<MainStore> mainStores = mainStoreService.getAllMainStores();
        return ResponseEntity.ok(mainStores);
    }
    @GetMapping("/type-in-out")
    public List<MainStore> getMainStoresByStockSpicesTypeInAndStockSpicesTypeOut(
            @RequestParam(required = false) String stockSpicesTypeIn,
            @RequestParam(required = false) String stockSpicesTypeOut) {

        if (stockSpicesTypeIn != null && stockSpicesTypeOut != null) {
            return mainStoreService.getMainStoresByStockSpicesTypeInAndStockSpicesTypeOut(stockSpicesTypeIn, stockSpicesTypeOut);
        } else if (stockSpicesTypeIn != null) {
            return mainStoreService.getMainStoresByStockSpicesTypeIn(stockSpicesTypeIn);
        } else if (stockSpicesTypeOut != null) {
            return mainStoreService.getMainStoresByStockSpicesTypeOut(stockSpicesTypeOut);
        } else {
            return mainStoreService.getAllMainStores();
        }
    }

}
