package br.com.crud_pet.api.Crud_pet.domain.veterinarian;

import br.com.crud_pet.api.Crud_pet.domain.addresss.AddressData;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterDataVet(
        @NotBlank
        @JsonAlias("nome")
        String name,

        @NotBlank
        String email,

        @NotBlank
        @JsonAlias("telefone")
        String telephone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        @JsonAlias("especialidade")
        Specialty specialty,

        @NotNull @Valid
        @JsonAlias("endereco")
        AddressData address) {
}
