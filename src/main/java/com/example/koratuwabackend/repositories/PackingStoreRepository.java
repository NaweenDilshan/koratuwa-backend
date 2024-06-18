package com.example.koratuwabackend.repositories;
import com.example.koratuwabackend.models.PackingStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingStoreRepository extends JpaRepository<PackingStore, Long> {
}
