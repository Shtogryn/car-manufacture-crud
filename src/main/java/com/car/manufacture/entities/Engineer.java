package com.car.manufacture.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Setter
@Getter
public class Engineer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long engineer_id;
    @Column
    private String name;
    @Column
    private String country;
    @Column
    private int car_id;
}
