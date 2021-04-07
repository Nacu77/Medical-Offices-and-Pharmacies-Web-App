package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MedicalOffice extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private ContactData contactData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @OneToMany(mappedBy = "medicalOffice", cascade = CascadeType.ALL)
    private Set<ServicePrice> servicesPrice = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @OneToMany(mappedBy = "medicalOffice", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    @Builder
    public MedicalOffice(Long id, String name, Doctor doctor, ContactData contactData, Address address, Schedule schedule, Set<ServicePrice> services, Specialty specialty, Set<Appointment> appointments) {
        super(id);
        this.name = name;
        this.doctor = doctor;
        this.contactData = contactData;
        this.address = address;
        this.schedule = schedule;
        this.servicesPrice = Objects.requireNonNullElseGet(services, HashSet::new);
        this.specialty = specialty;
        this.appointments = Objects.requireNonNullElseGet(appointments, HashSet::new);;
    }
}
