package com.cv.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cars")
public class Car {
    private static final String TABLE_SEQUENCE = "cars_id_seq";
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQUENCE)
    @SequenceGenerator(name = TABLE_SEQUENCE, sequenceName = TABLE_SEQUENCE, allocationSize = 1)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Integer price;

    @Column(name = "available")
    private Boolean available;

}
