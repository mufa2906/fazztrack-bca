package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long>{
  Boolean existsByNameIgnoreCase(String name);

  List<Role> findByName(String name);
}
