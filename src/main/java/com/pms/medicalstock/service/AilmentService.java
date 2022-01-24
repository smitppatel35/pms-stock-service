package com.pms.medicalstock.service;

import com.pms.medicalstock.entity.AilmentEntity;
import com.pms.medicalstock.entity.MedicineEntity;

import java.util.List;

public interface AilmentService {

    List<AilmentEntity> getAllAilment();

    List<MedicineEntity> getMedicinesByAilment(String ailment);
}
