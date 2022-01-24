package com.pms.medicalstock.controller;

import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/MedicineStockInformation")
    public ResponseEntity<Object> getAllMedicines() {
        List<MedicineEntity> medicines = medicineService.getAllMedicines();

        return ResponseEntity.ok(medicines);
    }
}
