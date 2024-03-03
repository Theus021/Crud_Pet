package br.com.crud_pet.api.Crud_pet.domain.consultation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    boolean existsByVeterinarianIdAndDate(Long veterinarian, LocalDateTime date);

    boolean existsByTutorId_IdAndDateBetween(Long tutorId, LocalDateTime firstHour, LocalDateTime lastHour);
}
