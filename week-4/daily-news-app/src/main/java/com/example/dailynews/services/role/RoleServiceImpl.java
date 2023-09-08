package com.example.dailynews.services.role;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Role;
import com.example.dailynews.payloads.req.role.AddRoleRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  RoleRepository roleRepository;

  @Override
  public ResponseEntity<?> addRoleService(AddRoleRequest request) {
    if (!(request.getRoleName().substring(0, 5).equals("ROLE_")) || request.getRoleName().length() < 6) {
      throw new IllegalArgumentException("Role name must be 'ROLE_(Rolename)'!");
    };

    Role role = roleRepository.findByName(request.getRoleName());// kalo ada->true->error, false->setisdeleted
    if (!Objects.isNull(role)) {
      if(!role.getIsDeleted()){
        throw new IllegalArgumentException("Role already exists!");
      } else {
        role.setIsDeleted(false);
      }
    } else {
      role = new Role(request.getRoleName());
    }
    roleRepository.save(role);

    return ResponseHandler.responseData(201, "Role successfully added!", role);

  }

  @Override
  public ResponseEntity<?> getRolesService() {
    List<Role> roles = roleRepository.findAll();

    return ResponseHandler.responseData(200, "Show all roles!", roles);
  }

  @Override
  public ResponseEntity<?> deleteRoleService(String name) {
    Role role = roleRepository.findByName(name);
    if (Objects.isNull(role)) {
      throw new IllegalArgumentException("Role is not found!");
    }
    
    role.setIsDeleted(true);
    roleRepository.save(role);

    return ResponseHandler.responseMessage(200, "Role successfully deleted!");
  }

}
