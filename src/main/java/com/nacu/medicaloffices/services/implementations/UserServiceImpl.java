package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.UserMapper;
import com.nacu.medicaloffices.api.model.UserDTO;
import com.nacu.medicaloffices.domain.User;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.UserRepository;
import com.nacu.medicaloffices.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public List<UserDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::userToUserDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = repository.findByUsername(username);
        if(user == null) {
            throw new ResourceNotFoundException();
        }
        return mapper.userToUserDTO(user);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = mapper.userDTOtoUser(userDTO);
        User savedUser = repository.save(user);
        return mapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO saveById(Long id, UserDTO userDTO) {
        User user = mapper.userDTOtoUser(userDTO);
        user.setId(id);
        User savedUser = repository.save(user);
        return mapper.userToUserDTO(savedUser);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
