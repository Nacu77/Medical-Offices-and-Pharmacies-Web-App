package com.nacu.medicaloffices.bootstrap;

import com.nacu.medicaloffices.domain.*;
import com.nacu.medicaloffices.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PharmacyOwnerRepository pharmacyOwnerRepository;
    private final SpecialtyRepository specialtyRepository;
    private final MedicineRepository medicineRepository;
    private final MedicineStockRepository medicineStockRepository;
    private final MedicalOfficeRepository medicalOfficeRepository;
    private final AppointmentRepository appointmentRepository;
    private final RecipeRepository recipeRepository;
    private final PharmacyRepository pharmacyRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public DataLoader(DoctorRepository doctorRepository, PatientRepository patientRepository, PharmacyOwnerRepository pharmacyOwnerRepository, SpecialtyRepository specialtyRepository, MedicineRepository medicineRepository, MedicineStockRepository medicineStockRepository, MedicalOfficeRepository medicalOfficeRepository, AppointmentRepository appointmentRepository, RecipeRepository recipeRepository, PharmacyRepository pharmacyRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.pharmacyOwnerRepository = pharmacyOwnerRepository;
        this.specialtyRepository = specialtyRepository;
        this.medicineRepository = medicineRepository;
        this.medicineStockRepository = medicineStockRepository;
        this.medicalOfficeRepository = medicalOfficeRepository;
        this.appointmentRepository = appointmentRepository;
        this.recipeRepository = recipeRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = userRepository.count();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        loadMedicines();
        loadSpecialties();

        loadRoles();
        loadUsers();

        loadMedicalOffices();
        loadPharmacies();

        loadAppointments();
        loadRecipes();
        loadMedicineStock();
    }

    private void loadRoles() {
        roleRepository.save(
                Role.builder()
                        .name("admin")
                        .build()
        );
        roleRepository.save(
                Role.builder()
                        .name("doctor")
                        .build()
        );
        roleRepository.save(
                Role.builder()
                        .name("pharmacy_owner")
                        .build()
        );
        roleRepository.save(
                Role.builder()
                        .name("patient")
                        .build()
        );
    }

    private void loadUsers() {
        userRepository.save(
                User.builder()
                        .username("admin77")
                        .password(new BCryptPasswordEncoder().encode("FaCeSpuneBecali77"))
                        .role(roleRepository.findByName("admin"))
                        .build()
        );
        userRepository.save(
                User.builder()
                        .username("florin")
                        .password(new BCryptPasswordEncoder().encode("florin"))
                        .patient(patientRepository.findByLastName("Nacu"))
                        .role(roleRepository.findByName("patient"))
                        .patient(
                                Patient.builder()
                                        .firstName("Florin")
                                        .lastName("Nacu")
                                        .contactData(
                                                ContactData.builder()
                                                        .email("florin@gmail.com")
                                                        .phoneNumber("0769876511")
                                                        .build())
                                        .build())
                        .build()
        );
        userRepository.save(
                User.builder()
                        .username("andreea")
                        .password(new BCryptPasswordEncoder().encode("andreea"))
                        .doctor(doctorRepository.findByLastName("Cristea"))
                        .role(roleRepository.findByName("doctor"))
                        .doctor(
                                Doctor.builder()
                                        .firstName("Andreea")
                                        .lastName("Cristea")
                                        .contactData(
                                                ContactData.builder()
                                                        .email("andreea@gmail.com")
                                                        .phoneNumber("0761234560")
                                                        .build())
                                        .build())
                        .build()
        );
        userRepository.save(
                User.builder()
                        .username("gica")
                        .password(new BCryptPasswordEncoder().encode("gica"))
                        .pharmacyOwner(pharmacyOwnerRepository.findByLastName("Petrescu"))
                        .role(roleRepository.findByName("pharmacy_owner"))
                        .pharmacyOwner(
                                PharmacyOwner.builder()
                                        .firstName("Gica")
                                        .lastName("Petrescu")
                                        .contactData(
                                                ContactData.builder()
                                                        .email("gica@gmail.com")
                                                        .phoneNumber("0731234567")
                                                        .build())
                                        .build())
                        .build()
        );
    }

    private void loadMedicines() {
        medicineRepository.save(
                Medicine.builder()
                        .name("Paracetamol")
                        .imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Nurofen")
                        .imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Aspirin")
                        .imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Paracetamol 2")
                        .imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Nurofen 2")
                        .imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Aspirin 2")
                        .imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Paracetamol 3")
                        .imageUrl("https://static.apoteca-farmacie.ro/assets/img/p/1446816-12085-large.jpg")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Nurofen 3")
                        .imageUrl("https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/heb/hd6/8869324357662/RBL1902106_Nurofen%20200%20mg%20tabs_carton%2012_fata07C%20Pack_Simulation.png")
                        .build()
        );
        medicineRepository.save(
                Medicine.builder()
                        .name("Aspirin 3")
                        .imageUrl("https://www.pilulka.ro/assets/image/2020-03/1584638093-aspirin-cardio-100-mg-28-comprimate-gastrorezistente.jpg?v=1584638093")
                        .build()
        );
    }

    private void loadSpecialties() {
        specialtyRepository.save(
                Specialty.builder()
                        .name("Dentistry")
                        .build()
        );
        specialtyRepository.save(
                Specialty.builder()
                        .name("Neurology")
                        .build()
        );
    }

    private void loadMedicalOffices() {
        medicalOfficeRepository.save(
                MedicalOffice.builder()
                        .name("Cristea's Dentist Office")
                        .doctor(doctorRepository.findByLastName("Cristea"))
                        .address(
                                Address.builder()
                                        .country("Romania")
                                        .city("Iasi")
                                        .street("Calea Aricilor")
                                        .number(35)
                                        .build())
                        .contactData(
                                ContactData.builder()
                                        .email("andreea_office@gmail.com")
                                        .phoneNumber("0761234561")
                                        .build())
                        .specialty(specialtyRepository.findByName("Dentistry"))
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
                                        .fridayEnd(LocalTime.of(18, 0))
                                        .build())
                        .build()
        );
        medicalOfficeRepository.save(
                MedicalOffice.builder()
                        .name("Cristea's Neurology Office")
                        .doctor(doctorRepository.findByLastName("Cristea"))
                        .address(
                                Address.builder()
                                        .country("Romania")
                                        .city("Iasi")
                                        .street("Calea Pisicilor")
                                        .number(12)
                                        .build())
                        .contactData(
                                ContactData.builder()
                                        .email("andreea_office2@gmail.com")
                                        .phoneNumber("0761234562")
                                        .build())
                        .specialty(specialtyRepository.findByName("Neurology"))
                        .schedule(
                                Schedule.builder()
                                        .mondayStart(LocalTime.of(8, 0))
                                        .mondayEnd(LocalTime.of(19, 0))
                                        .tuesdayStart(LocalTime.of(8, 0))
                                        .tuesdayEnd(LocalTime.of(19, 0))
                                        .wednesdayStart(LocalTime.of(7, 0))
                                        .wednesdayEnd(LocalTime.of(19, 0))
                                        .thursdayStart(LocalTime.of(8, 0))
                                        .thursdayEnd(LocalTime.of(17, 0))
                                        .fridayStart(LocalTime.of(8, 0))
                                        .fridayEnd(LocalTime.of(17, 0))
                                        .build())
                        .build()
        );
    }

    private void loadPharmacies() {
        pharmacyRepository.save(
                Pharmacy.builder()
                        .name("Catena")
                        .pharmacyOwner(pharmacyOwnerRepository.findByLastName("Petrescu"))
                        .address(
                                Address.builder()
                                        .country("Romania")
                                        .city("Bucuresti")
                                        .street("Calea Grivitei")
                                        .number(143)
                                        .build())
                        .contactData(
                                ContactData.builder()
                                        .email("catena@gmail.com")
                                        .phoneNumber("0761234532")
                                        .build())
                        .build()
        );
        pharmacyRepository.save(
                Pharmacy.builder()
                        .name("Farmacia Bucuria")
                        .pharmacyOwner(pharmacyOwnerRepository.findByLastName("Petrescu"))
                        .address(
                                Address.builder()
                                        .country("Romania")
                                        .city("Galati")
                                        .street("Calea Sarpelui")
                                        .number(143)
                                        .build())
                        .contactData(
                                ContactData.builder()
                                        .email("bucur@gmail.com")
                                        .phoneNumber("0761234312")
                                        .build())
                        .build()
        );
    }

    private void loadAppointments() {
        appointmentRepository.save(
                Appointment.builder()
                        .patient(patientRepository.findByLastName("Nacu"))
                        .medicalOffice(medicalOfficeRepository.findByName("Cristea's Dentist Office"))
                        .date(LocalDateTime.now())
                        .description("Vreau sa-mi albesc dintii.")
                        .build()
        );
    }

    private void loadRecipes() {
        recipeRepository.save(
                Recipe.builder()
                        .patient(patientRepository.findByLastName("Nacu"))
                        .description("Take 2 pills of paracetamol per day and one of aspirin when you wake up")
                        .medicines(Set.of(medicineRepository.findByName("Paracetamol"), medicineRepository.findByName("Aspirin")))
                        .build()
        );
    }

    private void loadMedicineStock() {
        medicineStockRepository.save(
                MedicineStock.builder()
                        .medicine(medicineRepository.findByName("Paracetamol"))
                        .pharmacy(pharmacyRepository.findByName("Catena"))
                        .amount(312)
                        .price(30.20)
                        .build()
        );
        medicineStockRepository.save(
                MedicineStock.builder()
                        .medicine(medicineRepository.findByName("Aspirin"))
                        .pharmacy(pharmacyRepository.findByName("Catena"))
                        .amount(1310)
                        .price(40)
                        .build()
        );

        medicineStockRepository.save(
                MedicineStock.builder()
                        .medicine(medicineRepository.findByName("Paracetamol 2"))
                        .pharmacy(pharmacyRepository.findByName("Farmacia Bucuria"))
                        .amount(312)
                        .price(30.20)
                        .build()
        );
        medicineStockRepository.save(
                MedicineStock.builder()
                        .medicine(medicineRepository.findByName("Aspirin 2"))
                        .pharmacy(pharmacyRepository.findByName("Farmacia Bucuria"))
                        .amount(1310)
                        .price(40)
                        .build()
        );
    }
}
