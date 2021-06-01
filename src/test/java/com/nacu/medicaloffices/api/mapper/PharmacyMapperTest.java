package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AddressDTO;
import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.domain.Address;
import com.nacu.medicaloffices.domain.ContactData;
import com.nacu.medicaloffices.domain.MedicineStock;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class PharmacyMapperTest {

    private final String NAME = "Catena";

    private final ContactData CONTACT_DATA = ContactData.builder().email("ph@email.com").build();
    private final Address ADDRESS = Address.builder().city("Bucharest").build();
    private final Set<MedicineStock> MEDICINE_STOCK_SET = Set.of(
            MedicineStock.builder().build(),
            MedicineStock.builder().build()
    );

    private final ContactDataDTO CONTACT_DATA_DTO = ContactDataDTO.builder().email("ph@email.com").build();
    private final AddressDTO ADDRESS_DTO = AddressDTO.builder().city("Bucharest").build();
    private final List<MedicineStockDTO> MEDICINE_STOCK_LIST = List.of(
            MedicineStockDTO.builder().build(),
            MedicineStockDTO.builder().build()
    );

    private final PharmacyMapper pharmacyMapper = PharmacyMapper.INSTANCE;

    @Test
    void pharmacyToPharmacyDTO() {
//        Pharmacy pharmacy = Pharmacy.builder().name(NAME).contactData(CONTACT_DATA). address(ADDRESS).medicineStock(MEDICINE_STOCK_SET).build();
//        PharmacyDTO pharmacyDTO = pharmacyMapper.pharmacyToPharmacyDTO(pharmacy);
//
//        assertEquals(NAME, pharmacyDTO.getName());
//        assertEquals(CONTACT_DATA.getEmail(), pharmacyDTO.getContactData().getEmail());
//        assertEquals(ADDRESS.getCity(), pharmacyDTO.getAddress().getCity());
//        assertEquals(MEDICINE_STOCK_SET.size(), pharmacyDTO.getMedicineStock().size());
    }

    @Test
    void pharmacyDTOtoPharmacy() {
//        PharmacyDTO pharmacyDTO = PharmacyDTO.builder().name(NAME).contactData(CONTACT_DATA_DTO). address(ADDRESS_DTO).medicineStock(MEDICINE_STOCK_LIST).build();
//        Pharmacy pharmacy = pharmacyMapper.pharmacyDTOtoPharmacy(pharmacyDTO);
//
//        assertEquals(NAME, pharmacy.getName());
//        assertEquals(CONTACT_DATA_DTO.getEmail(), pharmacy.getContactData().getEmail());
//        assertEquals(ADDRESS_DTO.getCity(), pharmacy.getAddress().getCity());
//        assertEquals(MEDICINE_STOCK_LIST.size(), pharmacy.getMedicineStock().size());
    }
}