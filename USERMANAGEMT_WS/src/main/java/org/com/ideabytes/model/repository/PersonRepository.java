package org.com.ideabytes.model.repository;

import org.com.ideabytes.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/** Repository manager for Person. */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

  /** Get collections of Person by name. */
  List<Person> findByLastName(@Param("name") String name);

}
