package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.RoleMapper;
import com.nacu.medicaloffices.api.model.RoleDTO;
import com.nacu.medicaloffices.domain.Role;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.RoleRepository;
import com.nacu.medicaloffices.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RoleDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::roleToRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::roleToRoleDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public RoleDTO create(RoleDTO roleDTO) {
        Role role = mapper.roleDTOtoRole(roleDTO);
        Role savedRole = repository.save(role);
        return mapper.roleToRoleDTO(savedRole);
    }

    @Override
    public RoleDTO saveById(Long id, RoleDTO roleDTO) {
        Role role = mapper.roleDTOtoRole(roleDTO);
        role.setId(id);
        Role savedRole = repository.save(role);
        return mapper.roleToRoleDTO(savedRole);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
