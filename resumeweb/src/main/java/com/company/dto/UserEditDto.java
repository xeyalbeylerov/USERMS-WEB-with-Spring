package com.company.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserEditDto {
    private Integer id;
    @Size(min = 3, max = 30, message = "Adınız minimum 3, maksimum 30 simvol ola bilər")
    @NotBlank(message = "Adınızda boşluq ola bilməz")
    private String name;
    @Size(min = 3, max = 30, message = "Soyadınız minimum 3, maksimum 30 simvol ola bilər")
    @NotBlank(message = "Soyadınızda boşluq ola bilməz")
    private String surname;
    @NotEmpty(message = "Email boş ola bilməz")
//    @Email(message = "Email düzgün deyil")
    @Email
    private String email;
    @Size(min = 11, max = 11, message = "Telefon nömrəniz 11 simvoldan ibarət olmalıdır")
    private String phone;
    @Size(min = 10, max = 300, message = "Profil açıqlamanız minimum 10, maksimum 300 simvol ola bilər")
    private String profileDesc;
    @NotNull(message = "Tarix boş ola bilməz")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    @Past(message = "Siz gələcəkdə doğula bilməzsiniz")
    private Date birthDate;
    @NotEmpty(message = "Adresiniz boş ola bilməz")
    private String address;
}
