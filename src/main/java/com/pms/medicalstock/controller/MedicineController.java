package com.pms.medicalstock.controller;

import com.pms.medicalstock.dto.ErrorResponse;
import com.pms.medicalstock.entity.AilmentEntity;
import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.exception.MedicineNotFoundException;
import com.pms.medicalstock.service.AilmentService;
import com.pms.medicalstock.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private AilmentService ailmentService;

    @GetMapping
    public ResponseEntity<Object> getAllMedicines() {
        List<MedicineEntity> medicines = medicineService.getAllMedicines();

        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/ailment")
    public ResponseEntity<Object> getAllAilments() {
        List<AilmentEntity> ailments = ailmentService.getAllAilment();
        return ResponseEntity.ok(ailments);
    }

    /**
     * @param ailmentName
     * @return List of medicines containing ailment
     */
    @GetMapping("/medicine/{ailmentName}")
    public ResponseEntity<?> getMedicinesByAilment(@PathVariable String ailmentName) {

        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/{medicineId}")
    public ResponseEntity<?> getMedicineById(@PathVariable("medicineId") int id) {
        try {
            MedicineEntity medicine = medicineService.getMedicineById(id);

            return ResponseEntity.ok(medicine);
        } catch (MedicineNotFoundException e) {

            return new ResponseEntity<>(new ErrorResponse("true", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
