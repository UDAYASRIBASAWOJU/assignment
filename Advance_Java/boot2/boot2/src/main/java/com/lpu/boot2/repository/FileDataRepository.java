package com.lpu.boot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.boot2.entity.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}
