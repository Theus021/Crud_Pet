package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.veterinarian.DetailsVeterinarianDTO;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.RegisterDataVet;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.Veterinarian;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.VeterinarianRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veterinario")
public class VeterinarianController {

    @Autowired
    private VeterinarianRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDataVet data, UriComponentsBuilder uriBilder){
        Veterinarian veterinarian = new Veterinarian(data);
        repository.save(veterinarian);

        var uri = uriBilder.path("/veterinario/{id}").buildAndExpand(veterinarian.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsVeterinarianDTO(veterinarian));
    }
}
