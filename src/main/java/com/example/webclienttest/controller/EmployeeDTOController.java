package com.example.webclienttest.controller;

import com.example.webclienttest.requesttojparest.v1.dto.EmployeeDTOV1;
import com.example.webclienttest.requesttojparest.v1.service.EmployeeServiceDTOClientV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employeedto")
public class EmployeeDTOController {

    private final EmployeeServiceDTOClientV1 clientV1;

    @Autowired
    public EmployeeDTOController(EmployeeServiceDTOClientV1 clientV1) {
        this.clientV1 = clientV1;
    }

    @GetMapping
    public List<EmployeeDTOV1> showAll() {
        return clientV1.findAll();
    }

    @GetMapping("/")
    public EmployeeDTOV1 showByNickname(@RequestParam("nickname") String nickname) {
        return clientV1.findByNickname(nickname);
    }

    @PostMapping("/create")
    public EmployeeDTOV1 createEmployee(@RequestBody EmployeeDTOV1 employeeDTOV1) {
        return clientV1.create(employeeDTOV1);
    }

    @PutMapping("/update")
    public EmployeeDTOV1 updateEmployee(@RequestBody EmployeeDTOV1 employeeDTOV1) {
        return clientV1.update(employeeDTOV1);
    }

    @DeleteMapping("/delete/")
    public void deleteEmployee(@RequestParam("nickname") String nickname) {
        clientV1.delete(nickname);
    }


}
