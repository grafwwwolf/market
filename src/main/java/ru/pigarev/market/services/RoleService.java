package ru.pigarev.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pigarev.market.model.Role;
import ru.pigarev.market.repositories.RoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
