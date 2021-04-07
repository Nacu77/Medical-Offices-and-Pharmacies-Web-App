package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Service extends BaseEntity {

    private String name;

    @Builder
    public Service(Long id, String name) {
        super(id);
        this.name = name;
    }
}
