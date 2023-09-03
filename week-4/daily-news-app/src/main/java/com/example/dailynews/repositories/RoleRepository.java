package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
  Boolean existsByRoleNameIgnoreCase(String roleName);
}
