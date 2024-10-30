package com.service.jenkins.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageRequest {

    private Long id;
    private String name;
    private String description;
}
