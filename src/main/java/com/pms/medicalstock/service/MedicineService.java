package com.pms.medicalstock.service;

import com.pms.medicalstock.entity.MedicineEntity;

import java.util.List;

public interface MedicineService {

    List<MedicineEntity> getAllMedicines();
}
