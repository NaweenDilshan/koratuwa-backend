package com.example.koratuwabackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="main-store")
public class MainStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeType;

    private String stockSpicesTypeIn;
    private String storeKeeperIn;
    private double QuantityIn;
    private double totalPriceIn;
    private double rateIn;
    private String companyIn;
    private String remarkIn;

    private String stockSpicesTypeOut;
    private String storeKeeperOut;
    private double QuantityOut;
    private double totalPriceOut;
    private double rateOut;
    private String companyOut;
    private String remarkOut;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
