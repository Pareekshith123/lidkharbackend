package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Dtos.UserRoleDto;
import com.backend.service.UserRoleService;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("create/{id}")
    public ResponseEntity<UserRoleDto> createUserRolesByUserId(@PathVariable Integer id, @RequestBody UserRoleDto userRoleDto) {
        UserRoleDto createdUserRole = userRoleService.createUserRolesByUserId(id, userRoleDto);
        return new ResponseEntity<>(createdUserRole, HttpStatus.CREATED);
    }
}
