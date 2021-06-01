package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.domain.ContactData;
import com.nacu.medicaloffices.domain.Pharmacy;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class PharmacyOwnerMapperTest {

    private final String FIRST_NAME = "Florin";
    private final String LAST_NAME = "Nacu";

    private final ContactData CONTACT_DATA = ContactData.builder().email("florin@email.com").build();
    private final Set<Pharmacy> PHARMACIES_SET = Set.of(Pharmacy.builder().build(), Pharmacy.builder().build());

    private final ContactDataDTO CONTACT_DATA_DTO = ContactDataDTO.builder().email("florin@email.com").build();
    private final List<PharmacyDTO> PHARMACIES_LIST = List.of(PharmacyDTO.builder().build(), PharmacyDTO.builder().build());

    private final PharmacyOwnerMapper pharmacyOwnerMapper = PharmacyOwnerMapper.INSTANCE;

    @Test
    void pharmacyOwnerToPharmacyOwnerDTO() {
//        PharmacyOwner pharmacyOwner = PharmacyOwner.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA).pharmacies(PHARMACIES_SET).build();
//        PharmacyOwnerDTO pharmacyOwnerDTO = pharmacyOwnerMapper.pharmacyOwnerToPharmacyOwnerDTO(pharmacyOwner);
//
//        assertEquals(FIRST_NAME, pharmacyOwnerDTO.getFirstName());
//        assertEquals(LAST_NAME, pharmacyOwnerDTO.getLastName());
//        assertEquals(CONTACT_DATA.getEmail(), pharmacyOwnerDTO.getContactData().getEmail());
//        assertEquals(PHARMACIES_SET.size(), pharmacyOwnerDTO.getPharmacies().size());
    }

    @Test
    void pharmacyOwnerDTOtoPharmacyOwner() {
//        PharmacyOwnerDTO pharmacyOwnerDTO = PharmacyOwnerDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA_DTO).pharmacies(PHARMACIES_LIST).build();
//        PharmacyOwner pharmacyOwner = pharmacyOwnerMapper.pharmacyOwnerDTOtoPharmacyOwner(pharmacyOwnerDTO);
//
//        assertEquals(FIRST_NAME, pharmacyOwner.getFirstName());
//        assertEquals(LAST_NAME, pharmacyOwner.getLastName());
//        assertEquals(CONTACT_DATA_DTO.getEmail(), pharmacyOwner.getContactData().getEmail());
//        assertEquals(PHARMACIES_LIST.size(), pharmacyOwner.getPharmacies().size());
    }
}