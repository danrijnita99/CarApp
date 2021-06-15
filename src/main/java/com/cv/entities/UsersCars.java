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
@Table(name = "users_cars")
public class UsersCars {

    private static final String TABLE_SEQUENCE = "users_cars_id_seq";
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQUENCE)
    @SequenceGenerator(name = TABLE_SEQUENCE, sequenceName = TABLE_SEQUENCE, allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
