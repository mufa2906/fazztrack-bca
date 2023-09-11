package id.tokobukufarhan.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tokobukufarhan.library.models.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
  Role findByName(String name);
}
