package exercise.controller;

import exercise.dto.ContactCreateDTO;
import exercise.dto.ContactDTO;
import exercise.model.Contact;
import exercise.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO createDTO) {
        var contact = toEntity(createDTO);
        contactRepository.save(contact);
        return toDTO(contact);
    }

    private ContactDTO toDTO(Contact contact) {
        var result = new ContactDTO();
        result.setPhone(contact.getPhone());
        result.setLastName(contact.getLastName());
        result.setFirstName(contact.getFirstName());
        result.setId(contact.getId());
        result.setCreatedAt(contact.getCreatedAt());
        result.setUpdatedAt(contact.getUpdatedAt());
        return result;
    }

    private Contact toEntity(ContactCreateDTO dto) {
        var result = new Contact();
        result.setFirstName(dto.getFirstName());
        result.setLastName(dto.getLastName());
        result.setPhone(dto.getPhone());
        return result;
    }
    // END
}
