package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service extends BaseEntity {

    private String name;

    @Builder
    public Service(Long id, String name) {
        super(id);
        this.name = name;
    }
}
