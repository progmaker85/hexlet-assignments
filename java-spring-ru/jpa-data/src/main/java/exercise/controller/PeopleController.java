package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    // BEGIN
    @GetMapping()
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.status(201).body(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personRepository.deleteById(id);
    }
    // END
}
