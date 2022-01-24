package com.pms.medicalstock.service.impl;

import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.repository.MedicineRepository;
import com.pms.medicalstock.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<MedicineEntity> getAllMedicines() {
        Iterable<MedicineEntity> stockEntities = medicineRepository.findAll();
        List<MedicineEntity> stockList = new ArrayList<>();
        stockEntities.forEach(stockList::add);
        return stockList;
    }
}
