package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.veterinarian.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity register(@RequestBody @Valid RegisterDataVetDTO data, UriComponentsBuilder uriBilder) {
        Veterinarian veterinarian = new Veterinarian(data);
        repository.save(veterinarian);

        var uri = uriBilder.path("/veterinario/{id}").buildAndExpand(veterinarian.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsVeterinarianDTO(veterinarian));
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAllByActiveTrue(paginacao).map(DetailsVeterinarianDTO::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updata(@RequestBody @Valid UpdateVeterinarianDTO data) {
        var veterinarian = repository.getReferenceById(data.id());
        veterinarian.updataInfoVet(data);

        return ResponseEntity.ok(new DetailsVeterinarianDTO(veterinarian));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var veterinarian = repository.getReferenceById(id);
        veterinarian.exclude(veterinarian);

        return ResponseEntity.noContent().build();
    }
}
