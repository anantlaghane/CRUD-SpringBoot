package com.demo.restapi.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.restapi.entity.Category;

public interface CategoryReposiotory extends JpaRepository<Category, Integer> {

}
