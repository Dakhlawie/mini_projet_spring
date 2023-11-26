package com.meriem.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriem.demo.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>{

}
