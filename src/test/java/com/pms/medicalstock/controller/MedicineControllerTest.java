package com.pms.medicalstock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MedicineControllerTest {

    @Autowired
    MedicineController controller;

    @Test
    void getAllMedicines() {
        ResponseEntity<Object> allMedicines = controller.getAllMedicines();

        assertEquals(HttpStatus.OK, allMedicines.getStatusCode());

    }
}