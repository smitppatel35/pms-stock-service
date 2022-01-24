package com.pms.medicalstock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "MEDICINE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String medicineName;
    private String chemicals;
    private Date dateOfExpiry;
    private Long stockCount;

    /**
     * Single medicine can be used in multiple ailment/ treatment
     * <p>
     * DOLO -> ORTHO
     * GENEral
     */

    @OneToMany
    @JoinTable(
            name = "MEDICINE_AILMENT_MAPPING",
            joinColumns = @JoinColumn(name = "AILMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MEDICINE_ID"))
    private List<AilmentEntity> ailments;
}
