package com.company.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter @Setter
public class UserForm {
    private Integer id;
    @NotEmpty
    @Size(min = 3)
    private String name;
    @NotEmpty
    private String surname;
    private Integer nationalityId;




    public UserForm() {
    }

    public UserForm(String name, String surname, Integer nationalityId) {
        this.name = name;
        this.surname = surname;
        this.nationalityId = nationalityId;
    }


}
