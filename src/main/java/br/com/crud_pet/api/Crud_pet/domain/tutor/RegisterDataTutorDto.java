package br.com.crud_pet.api.Crud_pet.domain.tutor;

import br.com.crud_pet.api.Crud_pet.domain.addresss.AddressDataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDataTutorDto(
        @NotBlank
        String tutor,

        @NotBlank
        String pet,

        @NotBlank
        @JsonAlias("idade")
        String age,

        @NotBlank
        @JsonAlias("peso")
        String weight,

        @NotBlank
        @JsonAlias("telefone")
        String telephone,

        @NotBlank
        String email,

        @NotNull @Valid
        @JsonAlias("endereco")
        AddressDataDTO address




) {
}
