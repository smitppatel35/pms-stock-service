package com.pms.medicalstock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AILMENT")
public class AilmentEntity {

    /**
     * Single ailment can be used in multiple medicines for treatment
     * <p>
     * ORTHO -> DOLO
     * PERA
     */

    @OneToMany
    @JoinTable(
            name = "MEDICINE_AILMENT_MAPPING",
            joinColumns = @JoinColumn(name = "MEDICINE_ID"),
            inverseJoinColumns = @JoinColumn(name = "AILMENT_ID"))

    List<MedicineEntity> medicines;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ailmentName;
}
