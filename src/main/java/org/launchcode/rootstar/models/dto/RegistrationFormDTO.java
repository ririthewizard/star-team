package org.launchcode.rootstar.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationFormDTO extends LoginFormDTO{

    @NotNull(message = "Password is required")
    @NotBlank(message = "Field can not be blank")
    @Size(min = 3, max = 20, message = "Password must be between 9-20 characters long")
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}


