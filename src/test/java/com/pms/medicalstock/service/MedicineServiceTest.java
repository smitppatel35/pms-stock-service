package com.pms.medicalstock.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MedicineServiceTest {

    @Autowired
    private MedicineService medicineService;

    @Test
    void test_getAllMedicines() {
        assertEquals(6, medicineService.getAllMedicines().size());
    }
}