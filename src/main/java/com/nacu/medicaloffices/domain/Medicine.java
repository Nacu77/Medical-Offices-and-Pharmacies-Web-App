package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Medicine extends BaseEntity {

    private String name;
    private String imageUrl;

    @Builder
    public Medicine(Long id, String name, String imageUrl) {
        super(id);
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
