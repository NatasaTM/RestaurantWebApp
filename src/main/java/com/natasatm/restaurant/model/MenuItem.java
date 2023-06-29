package com.natasatm.restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name="menu_item_entity")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private Boolean active;
    @NotNull
    private BigDecimal price;
    @NotEmpty
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "menuCategoryId")
    @NotNull
    private MenuEntityCategory menuCategory;

}
