package br.com.crud_pet.api.Crud_pet.domain.addresss;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDataDTO(
        @NotBlank
        @JsonAlias("bairro")
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        @JsonAlias("cidade")
        String city,

        @NotBlank
        String uf,

        @JsonAlias("complemento")
        String complement,

        @JsonAlias("numero")
        String number) {
}
