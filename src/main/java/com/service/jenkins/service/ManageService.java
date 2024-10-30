package com.service.jenkins.service;

import com.service.jenkins.entity.ManageEntity;
import com.service.jenkins.request.ManageRequest;

import java.util.List;

public interface ManageService {

    List<ManageEntity> findAll(ManageEntity entity);

    ManageEntity findById(Long id);

    ManageEntity created(ManageRequest request);

    ManageEntity update(ManageRequest request);

}
