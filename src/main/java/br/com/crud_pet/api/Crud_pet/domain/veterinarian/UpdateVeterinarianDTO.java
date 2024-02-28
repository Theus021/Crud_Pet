package br.com.crud_pet.api.Crud_pet.domain.veterinarian;

import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record UpdateVeterinarianDTO(
        @NotNull
        Long id,
        @JsonAlias("nome")
        String name,

        String email,
        @JsonAlias("telefone")
        String telephone,
        @JsonAlias("enderco")
        Address address





) {
}
