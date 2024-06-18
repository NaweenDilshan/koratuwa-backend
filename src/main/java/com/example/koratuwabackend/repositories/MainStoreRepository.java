package com.example.koratuwabackend.repositories;

import com.example.koratuwabackend.models.MainStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MainStoreRepository extends JpaRepository<MainStore, Long> {
    @Query("SELECT m FROM MainStore m WHERE m.stockSpicesTypeIn IS NOT NULL AND m.stockSpicesTypeIn <> ''")
    List<MainStore> findByStockSpicesTypeInIsNotEmpty();
    @Query("SELECT m FROM MainStore m WHERE m.stockSpicesTypeIn = :stockSpicesTypeIn")
    List<MainStore> findByStockSpicesTypeIn(String stockSpicesTypeIn);
    @Query("SELECT m FROM MainStore m WHERE m.stockSpicesTypeOut = :stockSpicesTypeOut")
    List<MainStore> findByStockSpicesTypeOut(String stockSpicesTypeOut);
    @Query("SELECT m FROM MainStore m WHERE m.stockSpicesTypeIn = :stockSpicesTypeIn AND m.stockSpicesTypeOut = :stockSpicesTypeOut")
    List<MainStore> findByStockSpicesTypeInAndStockSpicesTypeOut(String stockSpicesTypeIn, String stockSpicesTypeOut);





}
