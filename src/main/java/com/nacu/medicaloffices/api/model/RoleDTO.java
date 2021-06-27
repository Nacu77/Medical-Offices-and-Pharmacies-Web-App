package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private String name;

    @Builder
    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
