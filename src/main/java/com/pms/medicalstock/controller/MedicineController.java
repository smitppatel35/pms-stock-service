package com.pms.medicalstock.controller;

import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineController {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicineController.class);

    // Medicine service
    @Autowired
    private MedicineService medicineService;

    /**
     * @return List Of Medicines with Stock Count
     */

    // [microservice-name] [rest-end-point-name] started
    @GetMapping("/MedicineStockInformation")
    public ResponseEntity<Object> getAllMedicines() {
        LOGGER.info("[medical-stock-service] [MedicineStockInformation] initiated");

        List<MedicineEntity> medicines = medicineService.getAllMedicines();

        LOGGER.info("[medical-stock-service] [MedicineStockInformation] process completed");
        return ResponseEntity.ok(medicines);
    }
}
