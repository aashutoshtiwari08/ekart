package com.wipro.ekartManagemet_1.Dtos;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    @Size(min = 4,max = 20,message = "inappropriate name")
    private String name;
    private String lastname;
    @Email(message = "invalid email")
    private String email;
    private String mobile;

}
