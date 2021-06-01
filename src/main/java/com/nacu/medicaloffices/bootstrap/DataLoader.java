package com.nacu.medicaloffices.bootstrap;

import com.nacu.medicaloffices.domain.*;
import com.nacu.medicaloffices.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;
    private final PharmacyOwnerRepository pharmacyOwnerRepository;

    public DataLoader(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository, PatientRepository patientRepository, MedicineRepository medicineRepository, PharmacyOwnerRepository pharmacyOwnerRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
        this.patientRepository = patientRepository;
        this.medicineRepository = medicineRepository;
        this.pharmacyOwnerRepository = pharmacyOwnerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = doctorRepository.count();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Doctor doctor =
                Doctor.builder()
                        .firstName("Andreea")
                        .lastName("Cristea")
                        .contactData(ContactData.builder().email("andreea@gmail.com").phoneNumber("0761234560").build())
                        .build();

        Patient patient =
                Patient.builder()
                        .firstName("Florin")
                        .lastName("Nacu")
                        .contactData(ContactData.builder().email("florin@gmail.com").phoneNumber("0769876511").build())
                        .build();

        PharmacyOwner pharmacyOwner =
                PharmacyOwner.builder()
                        .firstName("Gica")
                        .lastName("Petrescu")
                        .contactData(ContactData.builder().email("gica@gmail.com").phoneNumber("0731234567").build())
                        .build();

        Specialty dentistrySpecialty = Specialty.builder().name("Dentistry").build();
        Specialty neurologySpecialty = Specialty.builder().name("Neurology").build();

//        Service teethWhiteningService = Service.builder().name("Teeth Whitening").build();
//        Service dentalScalerService = Service.builder().name("Dental Scaler").build();

        MedicalOffice medicalOffice1 =
                MedicalOffice.builder()
                        .name("Cristea's Dentist Office")
                        .doctor(doctor)
                        .address(Address.builder().country("Romania").city("Iasi").street("Calea Aricilor").number(35).build())
                        .contactData(ContactData.builder().email("andreea_office@gmail.com").phoneNumber("0761234561").build())
                        .specialty(dentistrySpecialty)
                        .schedule(
                                Schedule.builder()
                                        .mondayStart(LocalTime.of(9, 0))
                                        .mondayEnd(LocalTime.of(17, 0))
                                        .tuesdayStart(LocalTime.of(9, 0))
                                        .tuesdayEnd(LocalTime.of(17, 0))
                                        .wednesdayStart(LocalTime.of(9, 0))
                                        .wednesdayEnd(LocalTime.of(17, 0))
                                        .thursdayStart(LocalTime.of(9, 0))
                                        .thursdayEnd(LocalTime.of(17, 0))
                                        .fridayStart(LocalTime.of(9, 0))
                                        .fridayEnd(LocalTime.of(17, 0))
                                        .build()
                        )
                        .build();

        MedicalOffice medicalOffice2 =
                MedicalOffice.builder()
                        .name("Cristea's Neurology Office")
                        .doctor(doctor)
                        .address(Address.builder().country("Romania").city("Iasi").street("Calea Pisicilor").number(12).build())
                        .contactData(ContactData.builder().email("andreea_office2@gmail.com").phoneNumber("0761234562").build())
                        .specialty(neurologySpecialty)
                        .schedule(
                                Schedule.builder()
                                        .mondayStart(LocalTime.of(8, 0))
                                        .mondayEnd(LocalTime.of(19, 0))
                                        .tuesdayStart(LocalTime.of(8, 0))
                                        .tuesdayEnd(LocalTime.of(19, 0))
                                        .wednesdayStart(LocalTime.of(8, 0))
                                        .wednesdayEnd(LocalTime.of(19, 0))
                                        .thursdayStart(LocalTime.of(8, 0))
                                        .thursdayEnd(LocalTime.of(17, 0))
                                        .fridayStart(LocalTime.of(8, 0))
                                        .fridayEnd(LocalTime.of(17, 0))
                                        .build()
                        )
                        .build();

        doctor.getMedicalOffices().add(medicalOffice1);
        doctor.getMedicalOffices().add(medicalOffice2);

        Medicine medicine1 = Medicine.builder().name("Paracetamol").imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg").build();
        Medicine medicine2 = Medicine.builder().name("Nurofen").imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png").build();
        Medicine medicine3 = Medicine.builder().name("Aspirin").imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093").build();
        Medicine medicine4 = Medicine.builder().name("Paracetamol").imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg").build();
        Medicine medicine5 = Medicine.builder().name("Nurofen").imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png").build();
        Medicine medicine6 = Medicine.builder().name("Aspirin").imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093").build();
        Medicine medicine7 = Medicine.builder().name("Paracetamol").imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg").build();
        Medicine medicine8 = Medicine.builder().name("Nurofen").imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png").build();
        Medicine medicine9 = Medicine.builder().name("Aspirin").imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093").build();
        Medicine medicine10 = Medicine.builder().name("Paracetamol").imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg").build();
        Medicine medicine11 = Medicine.builder().name("Nurofen").imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png").build();
        Medicine medicine12 = Medicine.builder().name("Aspirin").imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093").build();

        Recipe recipe =
                Recipe.builder()
                        .description("Take 2 pills of paracetamol per day and one of aspirin when you wake up")
                        .patient(patient)
                        .medicines(Set.of(medicine1, medicine3))
                        .build();

        patient.getRecipes().add(recipe);

        Pharmacy pharmacy1 =
                Pharmacy.builder()
                        .name("Catena")
                        .pharmacyOwner(pharmacyOwner)
                        .address(Address.builder().country("Romania").city("Bucuresti").street("Calea Grivitei").number(143).build())
                        .contactData(ContactData.builder().email("catena@gmail.com").phoneNumber("0761234532").build())
                        .build();

        Pharmacy pharmacy2 =
                Pharmacy.builder()
                        .name("Farmacia Bucuria")
                        .pharmacyOwner(pharmacyOwner)
                        .address(Address.builder().country("Romania").city("Galati").street("Calea Sarpelui").number(143).build())
                        .contactData(ContactData.builder().email("bucur@gmail.com").phoneNumber("0761234312").build())
                        .build();

        MedicineStock medicineStock1 =
                MedicineStock.builder()
                        .pharmacy(pharmacy1)
                        .medicine(medicine2)
                        .amount(312)
                        .price(30.20)
                        .build();

        MedicineStock medicineStock2 =
                MedicineStock.builder()
                        .pharmacy(pharmacy1)
                        .medicine(medicine3)
                        .amount(1310)
                        .price(40)
                        .build();

        pharmacy1.getMedicineStock().add(medicineStock1);
        pharmacy1.getMedicineStock().add(medicineStock2);

        pharmacy2.getMedicineStock().add(medicineStock1);
        pharmacy2.getMedicineStock().add(medicineStock2);

        pharmacyOwner.getPharmacies().add(pharmacy1);
        pharmacyOwner.getPharmacies().add(pharmacy2);

        Appointment appointment =
                Appointment.builder()
                        .patient(patient)
                        .medicalOffice(medicalOffice1)
                        .date(LocalDateTime.now())
                        .description("Vreau sa-mi albesc dintii.")
                        .build();

        patient.getAppointments().add(appointment);

        specialtyRepository.save(dentistrySpecialty);
        specialtyRepository.save(neurologySpecialty);

        medicineRepository.save(medicine1);
        medicineRepository.save(medicine2);
        medicineRepository.save(medicine3);
        medicineRepository.save(medicine4);
        medicineRepository.save(medicine5);
        medicineRepository.save(medicine6);
        medicineRepository.save(medicine7);
        medicineRepository.save(medicine8);
        medicineRepository.save(medicine9);
        medicineRepository.save(medicine10);
        medicineRepository.save(medicine11);
        medicineRepository.save(medicine12);

        doctorRepository.save(doctor);
        patientRepository.save(patient);
        pharmacyOwnerRepository.save(pharmacyOwner);
    }
}
