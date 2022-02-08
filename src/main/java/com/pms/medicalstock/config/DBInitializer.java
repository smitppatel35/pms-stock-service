package com.pms.medicalstock.config;

import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.repository.MedicineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DBInitializer {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    private MedicineRepository medicineRepository;

    private SimpleDateFormat simpleDateFormat;

    /**
     * This method used for initialize database.
     * <p>
     * This method calls after dependency injection done due to
     * <code>@PostConstruct</code> Annotation
     * <p>
     * Link: https://docs.oracle.com/javaee/7/api/javax/annotation/PostConstruct.html
     */
    @PostConstruct
    private void init() throws ParseException {

        LOGGER.info("[medical-stock-service] [MedicineStockInformation] Database initialization started");

        // Parsing String to java.util.Date Object
        simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        medicine1();
        medicine2();
        medicine3();
        medicine4();
        medicine5();
        medicine6();

        LOGGER.info("[medical-stock-service] [MedicineStockInformation] Database initialization Completed");
    }

    private void medicine1() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("DOLO-650");
        medicineEntity.setTargetAilments("General");
        medicineEntity.setChemicalComposition("Peracetamol");
        medicineEntity.setNumbersOfTabletsInStock(1000L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("05-02-2023"));

        medicineRepository.save(medicineEntity);
    }

    private void medicine2() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("Gaviscon");
        medicineEntity.setTargetAilments("General");
        medicineEntity.setChemicalComposition("Sodium Alginate I.P: 250 mg, Sodium Bicarbonate I.P:133.5 mg. Calcium CarbonateI.P: 80 mg");
        medicineEntity.setNumbersOfTabletsInStock(100L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("12-2-2022"));

        medicineRepository.save(medicineEntity);
    }

    private void medicine3() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("Orthoherb");
        medicineEntity.setTargetAilments("Orthopaedics");
        medicineEntity.setChemicalComposition("ErandaVasa, Vilvam, Nimba, Dusparsha, Amalaki, Manjishta, Nirgundi, Chithrakam, Kataka, Gokshurah, Shatavari, Pashanabheda.");
        medicineEntity.setNumbersOfTabletsInStock(500L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("7-12-2022"));

        medicineRepository.save(medicineEntity);
    }

    private void medicine4() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("Cholecalciferol");
        medicineEntity.setTargetAilments("Orthopaedics");
        medicineEntity.setChemicalComposition("Vitamin D3");
        medicineEntity.setNumbersOfTabletsInStock(1000L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("14-10-2021"));

        medicineRepository.save(medicineEntity);
    }

    private void medicine5() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("Cyclopam");
        medicineEntity.setTargetAilments("Gynaecology");
        medicineEntity.setChemicalComposition("Dicyclomine 20mg,Paracetamol 500mg");
        medicineEntity.setNumbersOfTabletsInStock(1234L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("22-09-2022"));

        medicineRepository.save(medicineEntity);
    }

    private void medicine6() throws ParseException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setMedicineName("Hilact");
        medicineEntity.setTargetAilments("Gynaecology");
        medicineEntity.setChemicalComposition("Cyproheptadine 2mg, Tricholine Citrate 275mg, Sorbitol 3.575mg");
        medicineEntity.setNumbersOfTabletsInStock(1500L);
        medicineEntity.setDateOfExpiry(simpleDateFormat.parse("18-04-2023"));

        medicineRepository.save(medicineEntity);
    }

}
