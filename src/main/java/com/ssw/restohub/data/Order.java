package com.ssw.restohub.data;

import com.ssw.restohub.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
    private Long orderId;

    @Column(name = "customerId",nullable = false)
    private String customerId;

    @Column(name = "orderDateTime",nullable = false)
    private LocalDateTime orderDateTime;

    @Column(name = "totalOrderAmount",nullable = false)
    private double totalOrderAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus",nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "instructions")
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "restaurantId",nullable = false)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
    List<OrderItem> orderItems;


}
