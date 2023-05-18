package com.example.webclienttest.requesttojparest.v1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTOV1 {

    @Size(max = 20)
    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @Size(max = 50)
    @NotNull
    private String email;

    @Size(max = 20)
    @NotNull
    private String nickname;

}
