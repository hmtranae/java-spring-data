package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.AppCategory;
import org.springframework.data.repository.CrudRepository;

public interface AppCategoryRepository extends CrudRepository<AppCategory, Integer> {
  public AppCategory findByName(String name);
}
