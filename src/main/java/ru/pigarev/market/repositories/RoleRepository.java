package ru.pigarev.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pigarev.market.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
