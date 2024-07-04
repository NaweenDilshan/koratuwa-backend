package com.example.koratuwabackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String billNo;
    private Date date;
    private String saleRef;
    private String mobile;
    private String customerName;
    private String address;
    private double total;
    private double returns;
    private double netTotal;
    private String receivedBy;
    private String salesRefBy;
    private String returnOrNot;

    @ElementCollection
    @CollectionTable(name = "product_details", joinColumns = @JoinColumn(name = "bill_id"))
    private List<Product> products;

    @ElementCollection
    @CollectionTable(name = "return_details", joinColumns = @JoinColumn(name = "bill_id"))
    private List<ReturnDetail> returnDetails;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Product {
        private String product;
        private String type;
        private int quantity;
        private double rate;
        private double price;
    }

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReturnDetail {
        private String spicesType;
        private String packetType;
        private int quantity;
        private double rate;
        private double price;
    }
}
