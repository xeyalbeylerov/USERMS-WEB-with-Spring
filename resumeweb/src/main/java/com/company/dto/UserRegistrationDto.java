package com.company.dto;

import com.company.validator.FieldMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
@Getter @Setter
public class UserRegistrationDto {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @Email(message = "Email düzgün deyil",regexp = ".+@.+\\..+")
    private String email;

}
