package me.mikkalmc.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.mikkalmc.login.model.Role;

@Repository("roleRepostory")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}