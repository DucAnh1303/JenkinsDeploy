package com.service.jenkins.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageRequest {


    private Long id;
    @NotBlank(message = "name is not null")
    private String name;
    @NotBlank(message = "description is not null")
    private String description;
}
