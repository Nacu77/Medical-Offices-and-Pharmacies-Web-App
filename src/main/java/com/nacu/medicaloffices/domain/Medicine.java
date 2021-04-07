package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Medicine extends BaseEntity {

    private String name;

    @Builder
    public Medicine(Long id, String name) {
        super(id);
        this.name = name;
    }
}
