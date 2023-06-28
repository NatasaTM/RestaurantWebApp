package com.natasatm.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_entity")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menuEntity_menuItemEntity",
            joinColumns = @JoinColumn(name = "menuEntity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menuItemEntity_id", referencedColumnName = "id")
    )
    private List<MenuItemEntity> menuItems;


}
