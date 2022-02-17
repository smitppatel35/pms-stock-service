package com.pms.medicalstock.repository;

import com.pms.medicalstock.entity.MedicineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends CrudRepository<MedicineEntity, Integer> {
}
