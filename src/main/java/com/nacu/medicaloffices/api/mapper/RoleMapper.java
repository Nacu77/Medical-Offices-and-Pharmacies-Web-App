package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.RoleDTO;
import com.nacu.medicaloffices.domain.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO roleToRoleDTO(Role role);
    Role roleDTOtoRole(RoleDTO roleDTO);
}
