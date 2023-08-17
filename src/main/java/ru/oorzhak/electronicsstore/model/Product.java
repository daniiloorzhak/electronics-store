package ru.oorzhak.electronicsstore.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long position;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String type;
    @NotNull
    @Min(0)
    private Double price;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = {
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    @JoinTable(name = "window_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "window_id"))
    private Window window;
}
