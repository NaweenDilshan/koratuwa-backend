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
@Table(name="packing-store")

public class PackingStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deliveryOrNot;
    private String storePackingTypeIn; //Peppercorns
    private double OutSpicesQuantity; //2kg
    private String packetTypeIn; //50g, 100g
    private double grindQuantity;
    private String packetQuantityIn;
    private String nameIn;
    private String remarkIn;

    private String storePackingTypeOut; //Peppercorns
    private String packetTypeOut; //50g, 100g
    private String packetQuantityOut;
    private String nameOut;
    private String remarkOut;
}
