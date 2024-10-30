package com.service.jenkins.repository;

import com.service.jenkins.entity.ManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRepository extends JpaRepository<ManageEntity,Long> {
}
