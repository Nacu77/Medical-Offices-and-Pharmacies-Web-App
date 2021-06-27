package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.UserDTO;
import com.nacu.medicaloffices.domain.User;
import com.nacu.medicaloffices.repositories.RoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = { PatientMapper.class, DoctorMapper.class, PharmacyMapper.class },
        componentModel = "spring"
)
public abstract class UserMapper {

    @Autowired
    protected RoleRepository repository;

    public abstract UserDTO userToUserDTO(User user);

    @Mapping(target = "role", expression = "java(repository.findByName(userDTO.getRole().getName()))")
    public abstract User userDTOtoUser(UserDTO userDTO);
}
