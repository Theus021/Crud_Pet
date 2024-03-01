package br.com.crud_pet.api.Crud_pet.domain.tutor;

import br.com.crud_pet.api.Crud_pet.domain.addresss.AddressDataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTutorDto(
        @NotNull
        Long id,

        String tutor,
        String pet,

        @JsonAlias("idade")
        String age,

        @JsonAlias("peso")
        String weight,

        @JsonAlias("telefone")
        String telephone,

        String email,
        @JsonAlias("endereco")
        AddressDataDTO address
) {
}
