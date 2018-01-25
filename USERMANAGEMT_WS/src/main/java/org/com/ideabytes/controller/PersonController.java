package org.com.ideabytes.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.com.ideabytes.exception.EntityNotFoundException;
import org.com.ideabytes.model.Person;
import org.com.ideabytes.model.repository.PersonRepository;


/** Simple controller to illustrate templates. */
@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

  /** Person repository. */
  @Autowired
  private transient PersonRepository repository;

  /**
   * Person retriever.
   * @return Person
   */
  
  @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getPerson(@PathVariable final Long personId) throws EntityNotFoundException {
    final Person person = repository.findOne(personId);
    if (person == null) {
    	 throw new EntityNotFoundException(Person.class, "id", personId.toString());
      //return ResponseEntity.notFound().build();
    }
    final Resource<Person> resource = new Resource<Person>(person);
    resource.add(linkTo(methodOn(PersonController.class).getPerson(personId)).withSelfRel());

    return ResponseEntity.ok(resource);
  }

  /**
   * Person creation.
   * @return Person
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody public ResponseEntity<?> savePerson(@RequestBody final Person person) throws EntityNotFoundException {
    final Person persistedPerson = repository.save(person);
    final Resource<Person> resource = new Resource<Person>(persistedPerson);
    resource.add(
        linkTo(methodOn(PersonController.class).getPerson(persistedPerson.getId())).withSelfRel()
    );
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(resource);
  }

}
