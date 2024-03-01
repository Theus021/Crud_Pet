package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.tutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity listTutor(@PageableDefault(size = 10, sort = {"tutor"}) Pageable pageable){
        var page = repository.findAll(pageable).map(DetailsDataTutorDTO::new);

        return ResponseEntity.ok().body(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateTutorDto data){
        var tutor = repository.getReferenceById(data.id());
        tutor.updateinf(data);

        return ResponseEntity.ok(new DetailsDataTutorDTO(tutor));
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTutor(@PathVariable Long id){
        var tutor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsDataTutorDTO(tutor));
    }


}
