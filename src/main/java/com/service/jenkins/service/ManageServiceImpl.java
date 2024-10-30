package com.service.jenkins.service;

import com.service.jenkins.entity.ManageEntity;
import com.service.jenkins.repository.ManageRepository;
import com.service.jenkins.request.ManageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManageServiceImpl implements ManageService {

    private final ManageRepository manageRepository;

    @Override
    public List<ManageEntity> findAll(ManageEntity entity) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase() // Bỏ qua phân biệt hoa thường
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // Sử dụng LIKE cho các trường String

        Example<ManageEntity> example = Example.of(entity, matcher);
        return manageRepository.findAll(example);
    }

    @Override
    public ManageEntity findById(Long id) {
        try {
            return manageRepository.findById(id).get();
        } catch (Exception e) {
            return new ManageEntity();
        }
    }

    @Override
    public ManageEntity created(ManageRequest request) {
        ManageEntity manageEntity = new ManageEntity(request.getName(), request.getDescription());
        manageEntity = manageRepository.save(manageEntity);
        return manageEntity;
    }

    @Override
    public ManageEntity update(ManageRequest request) {
        if (manageRepository.existsById(request.getId())) {
            ManageEntity manageEntity = new ManageEntity(request.getId(), request.getName(), request.getDescription());
            manageEntity = manageRepository.save(manageEntity);
            return manageEntity;
        }
        return null;
    }
}
