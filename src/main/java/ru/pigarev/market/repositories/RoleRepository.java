package ru.pigarev.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pigarev.market.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
