package com.pms.medicalstock.service;

import com.pms.medicalstock.dto.StockUpdateDto;
import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.exception.MedicineNotFoundException;

import java.util.List;

public interface MedicineService {

    List<MedicineEntity> getAllMedicines();

    void updateStock(StockUpdateDto updateDto) throws MedicineNotFoundException;
}
