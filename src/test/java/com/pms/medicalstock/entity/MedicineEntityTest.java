package com.pms.medicalstock.entity;

import com.pms.medicalstock.repository.MedicineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MedicineEntityTest {

    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    void test_medicineEntity() throws ParseException {
        Optional<MedicineEntity> optionalMedicineEntity = medicineRepository.findById(1);

        if (optionalMedicineEntity.isPresent()) {
            MedicineEntity mockEntity = new MedicineEntity();
            mockEntity.setId(1);
            mockEntity.setMedicineName("DOLO-650");
            mockEntity.setTargetAilments("General");
            mockEntity.setChemicalComposition("Peracetamol");
            mockEntity.setNumbersOfTabletsInStock(1000L);
            mockEntity.setDateOfExpiry(new SimpleDateFormat("dd-mm-yyyy").parse("05-02-2023"));

            assertEquals(mockEntity, optionalMedicineEntity.get());
        }
    }

}