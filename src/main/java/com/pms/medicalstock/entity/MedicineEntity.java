package com.pms.medicalstock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private String chemicalComposition;
    private Date dateOfExpiry;
    private Long numbersOfTabletsInStock;
    private String targetAilments;
}
