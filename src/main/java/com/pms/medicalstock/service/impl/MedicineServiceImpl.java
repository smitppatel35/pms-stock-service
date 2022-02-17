package com.pms.medicalstock.service.impl;

import com.pms.medicalstock.dto.StockUpdateDto;
import com.pms.medicalstock.entity.MedicineEntity;
import com.pms.medicalstock.exception.MedicineNotFoundException;
import com.pms.medicalstock.repository.MedicineRepository;
import com.pms.medicalstock.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public void updateStock(StockUpdateDto updateDto)
            throws MedicineNotFoundException {

        LOGGER.debug("[medical-stock-service] [MedicineStockInformation] Medicine Update service started");

        Optional<MedicineEntity> medicineEntity = medicineRepository.findById(updateDto.getMedicineId());
        if (medicineEntity.isPresent()) {
            MedicineEntity medicine = medicineEntity.get();
            long remainingMedicines = medicine.getNumbersOfTabletsInStock() - updateDto.getDemand();

            if (remainingMedicines > 0) {
                LOGGER.debug("[medical-stock-service] [MedicineStockInformation] MedicineId: " + updateDto.getMedicineId() + " Updated, Remaining Stock: " + remainingMedicines);

                medicine.setNumbersOfTabletsInStock(remainingMedicines);
                medicineRepository.save(medicine);
            } else {
                LOGGER.debug("[medical-stock-service] [MedicineStockInformation] MedicineId: " + updateDto.getMedicineId() + " Stock isn't available");
                throw new MedicineNotFoundException("Medicine Not Found.");
            }
        } else {
            LOGGER.debug("[medical-stock-service] [MedicineStockInformation] MedicineId: " + updateDto.getMedicineId() + " Not Found");
            throw new MedicineNotFoundException("Medicine Not Found.");
        }
    }
}
