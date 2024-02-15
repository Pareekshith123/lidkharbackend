package com.backend.Dtos;

public class UserRoleDto {
    
    private Long roleId;
    private String role;
    private String modelPermission;

    public UserRoleDto() {
    }

    public UserRoleDto(Long roleId, String role, String modelPermission) {
        this.roleId = roleId;
        this.role = role;
        this.modelPermission = modelPermission;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getModelPermission() {
        return modelPermission;
    }

    public void setModelPermission(String modelPermission) {
        this.modelPermission = modelPermission;
    }
}
