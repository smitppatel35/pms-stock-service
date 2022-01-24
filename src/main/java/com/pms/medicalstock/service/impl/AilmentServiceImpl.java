package com.pms.medicalstock.service.impl;

import com.pms.medicalstock.entity.AilmentEntity;
import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.repository.AilmentRepository;
import com.pms.medicalstock.service.AilmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AilmentServiceImpl implements AilmentService {

    @Autowired
    private AilmentRepository ailmentRepository;

    @Override
    public List<AilmentEntity> getAllAilment() {
        Iterable<AilmentEntity> ailmentEntities = ailmentRepository.findAll();

        List<AilmentEntity> ailmentList = new ArrayList<>();
        ailmentEntities.forEach(ailmentList::add);

        return ailmentList;

    }

    @Override
    public List<MedicineEntity> getMedicinesByAilment(String ailment) {

        Iterable<MedicineEntity> medicineEntityIterable = ailmentRepository.findAllByAilmentName(ailment);
        List<MedicineEntity> medicinesList = new ArrayList<>();

        medicineEntityIterable.forEach(medicinesList::add);

        return medicinesList;
    }
}
