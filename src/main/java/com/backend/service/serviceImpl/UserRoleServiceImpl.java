package com.backend.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dtos.UserRoleDto;
import com.backend.Entities.User;
import com.backend.Entities.UserRoles;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.UserRepo;
import com.backend.repository.UserRoleRepo;
import com.backend.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
  @Autowired
  private UserRepo userRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRoleDto createUserRolesByUserId(Integer id, UserRoleDto userRoleDto) {

       User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "userId", id));
        
         UserRoles userRole = dtoToUserRole(userRoleDto);
       userRole.setRole(userRoleDto.getRole());
       userRole.setModelPermission(userRoleDto.getModelPermission());
       userRole.setUser(user);
         UserRoles createdUserRole =this.userRoleRepo.save(userRole);
         return this.userRoleToDto(createdUserRole);
    }

    @Override
    public UserRoleDto UpdateUserRolesByUserId(Integer id, Long roleId, UserRoleDto userRoleDto) {

        // Implementation logic to update user roles by user ID and role ID
        // Example:
        // UserRole existingUserRole = userRoleRepository.findByUserIdAndRoleId(id, roleId)
        //        .orElseThrow(() -> new ResourceNotFoundException("UserRole", "userId", id, "roleId", roleId));
        // existingUserRole.setRoleName(userRoleDto.getRoleName());
        // UserRole updatedUserRole = userRoleRepository.save(existingUserRole);
        // return userRoleToDto(updatedUserRole);
        return null;
    }

    @Override
    public List<UserRoleDto> getAllRoles() {

         List<UserRoles> userRoles = userRoleRepo.findAll();
         return userRoles.stream().map(this::userRoleToDto).collect(Collectors.toList());
       
    }

    @Override
    public List<UserRoleDto> getRolesByUserId(Integer id) {
        // Implementation logic to retrieve user roles by user ID
        // Example:
        // List<UserRole> userRoles = userRoleRepository.findByUserId(id);
        // return userRoles.stream().map(this::userRoleToDto).collect(Collectors.toList());
        return null;
    }

    @Override
    public UserRoleDto getRoleByRoleId(Long roleId) {

         UserRoles userRole = userRoleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole", "roleId", roleId));
         return userRoleToDto(userRole);
      
    }

    @Override
    public String deleteRole(Long roleId) {
  
         UserRoles userRole = userRoleRepo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole", "roleId", roleId));
         userRoleRepo.delete(userRole);
         return "User role deleted successfully";
    }

    private UserRoleDto userRoleToDto(UserRoles userRole) {

        return modelMapper.map(userRole, UserRoleDto.class);
    }

    private UserRoles dtoToUserRole(UserRoleDto userRoleDto) {
        return modelMapper.map(userRoleDto, UserRoles.class);
    }

	
}
