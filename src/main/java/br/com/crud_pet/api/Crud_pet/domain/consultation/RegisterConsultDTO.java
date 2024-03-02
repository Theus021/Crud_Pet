package br.com.crud_pet.api.Crud_pet.domain.consultation;

import br.com.crud_pet.api.Crud_pet.domain.veterinarian.Specialty;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegisterConsultDTO(
        @JsonAlias("veterinario")
        Long veterinarianId,

        @NotNull
        @JsonAlias("tutor")
        Long tutorId,

        @NotNull
        @Future
        LocalDateTime date,

        @NotNull
        @JsonAlias("especialidade")
        Specialty specialty

) {
}
