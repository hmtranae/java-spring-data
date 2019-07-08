package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IdeaRepository extends CrudRepository<Idea, Integer> {

  // Generic of CrudRepository
  // first is what entity we're manipulating
  // second is the data type we use to identify each entity

  public Idea findByName(String name);

  public List<Idea> findAllByName(String name);

  @Query("SELECT i from Idea i where i.name like :namePrefix%")
  public Idea whereNameStartsWith(@Param("namePrefix") String namePrefix);
}
