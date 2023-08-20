package ru.oorzhak.electronicsstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "windows")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Window {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String type;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "window_product",
            joinColumns = @JoinColumn(name = "window_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
}
