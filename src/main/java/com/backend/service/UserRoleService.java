package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.UserRoleDto;
@Service
public interface UserRoleService {
   UserRoleDto createUserRolesByUserId(Integer id ,UserRoleDto userRoleDto );
   UserRoleDto UpdateUserRolesByUserId(Integer id,Long roleId , UserRoleDto userRoleDto);
   List<UserRoleDto>getAllRoles();
   List<UserRoleDto>getRolesByUserId(Integer id);
  UserRoleDto getRoleByRoleId(Long roleId);
  String deleteRole(Long roleId);
   
}
