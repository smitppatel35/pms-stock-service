package com.pms.medicalstock.repository;

import com.pms.medicalstock.entity.AilmentEntity;
import com.pms.medicalstock.entity.MedicineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AilmentRepository extends CrudRepository<AilmentEntity, Integer> {

    Iterable<MedicineEntity> findAllByAilmentName(String ailmentName);

}
