package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.repositories.AppCategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCategorySeeder implements CommandLineRunner {

  private AppCategoryRepository appCategoryRepository;

  @Autowired
  public AppCategorySeeder(AppCategoryRepository appCategoryRepository) {
    this.appCategoryRepository = appCategoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> seedList = new ArrayList<>();
    seedList.add("Social Media");
    seedList.add("Productivity");
    seedList.add("Games");
    seedList.add("Self Help");

    for (String category : seedList) {
      AppCategory appCategory = appCategoryRepository.findByName(category);
      if (appCategory == null) {
        AppCategory newCategory = new AppCategory();
        newCategory.setName(category);
        appCategoryRepository.save(newCategory);
      }
    }
  }
}
