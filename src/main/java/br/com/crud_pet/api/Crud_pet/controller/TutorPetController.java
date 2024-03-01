package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.tutor.DetailsDataTutorDTO;
import br.com.crud_pet.api.Crud_pet.domain.tutor.RegisterDataTutorDto;
import br.com.crud_pet.api.Crud_pet.domain.tutor.Tutor;
import br.com.crud_pet.api.Crud_pet.domain.tutor.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tutor")
public class TutorPetController {

    @Autowired
    private TutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerTutor(@RequestBody @Valid RegisterDataTutorDto data, UriComponentsBuilder uriBilder){
        var tutor = new Tutor(data);
        repository.save(tutor);

        URI uri = uriBilder.path("/tutor/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsDataTutorDTO(tutor));
    }
}
