package com.nacu.medicaloffices.services;

import com.nacu.medicaloffices.api.model.UserDTO;

public interface UserService extends CrudService<UserDTO, Long> {
    UserDTO findByUsername(String username);
}
