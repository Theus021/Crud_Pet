package br.com.crud_pet.api.Crud_pet.domain.consultation;

import java.time.LocalDateTime;

public record DetailsConsultationDTO(Long id, Long veterinarianId, Long tutorId, LocalDateTime date) {
    public DetailsConsultationDTO(Consultation consult) {
        this(consult.getId(), consult.getVeterinarian().getId(), consult.getTutorId().getId(), consult.getDate());
    }
}
