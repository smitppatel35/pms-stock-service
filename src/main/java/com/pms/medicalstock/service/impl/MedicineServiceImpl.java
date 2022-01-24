package com.pms.medicalstock.service.impl;

import com.pms.medicalstock.entity.AilmentEntity;
import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.exception.MedicineNotFoundException;
import com.pms.medicalstock.repository.AilmentRepository;
import com.pms.medicalstock.repository.MedicineRepository;
import com.pms.medicalstock.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private AilmentRepository ailmentRepository;

    @Override
    public List<MedicineEntity> getAllMedicines() {
        Iterable<MedicineEntity> stockEntities = medicineRepository.findAll();
        Iterable<AilmentEntity> ailmentEntities = ailmentRepository.findAll();
        List<MedicineEntity> stockList = new ArrayList<>();
        stockEntities.forEach(stockList::add);
        return stockList;
    }

    @Override
    public MedicineEntity getMedicineById(int id) throws MedicineNotFoundException {
        Optional<MedicineEntity> medicineEntityOptional = medicineRepository.findById(id);


        if (medicineEntityOptional.isPresent()) {
            return medicineEntityOptional.get();
        } else {
            throw new MedicineNotFoundException("Medicine Not Found");
        }
    }
}
