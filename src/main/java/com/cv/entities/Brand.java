package com.cv.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "brands")
public class Brand {
    private static final String TABLE_SEQUENCE = "brands_id_seq";
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQUENCE)
    @SequenceGenerator(name = TABLE_SEQUENCE, sequenceName = TABLE_SEQUENCE, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private Date createdDate;
}
