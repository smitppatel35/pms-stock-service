package com.pms.medicalstock.repository;

import com.pms.medicalstock.entity.MedicineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MedicineRepositoryTest {

    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    void test_fetchAll_medicines() {
        Iterable<MedicineEntity> iterable = medicineRepository.findAll();
        List<MedicineEntity> list = new ArrayList<>();
        iterable.forEach(list::add);

        assertEquals(6, list.size());
    }


}