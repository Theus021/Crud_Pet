package br.com.crud_pet.api.Crud_pet.domain.tutor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
