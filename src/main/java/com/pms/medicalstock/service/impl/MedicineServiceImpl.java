package com.pms.medicalstock.service.impl;

import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.repository.MedicineRepository;
import com.pms.medicalstock.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicineServiceImpl.class);

    @Autowired
    private MedicineRepository medicineRepository;

    // Returns All medicines from database
    @Override
    public List<MedicineEntity> getAllMedicines() {
        LOGGER.debug("[medical-stock-service] [MedicineStockInformation] Medicine Retrieval operation started");
        Iterable<MedicineEntity> stockEntities = medicineRepository.findAll();
        List<MedicineEntity> stockList = new ArrayList<>();
        stockEntities.forEach(stockList::add);
        LOGGER.debug("[medical-stock-service] [MedicineStockInformation] Total " + stockList.size() + " Medicine Retrieval operation done");
        return stockList;
    }
}
