package br.com.crud_pet.api.Crud_pet.domain.veterinarian;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

    Page<Veterinarian> findAllByActiveTrue(Pageable paginacao);

    @Query("""
            select v from Veterinarian v
            where
            v.active = true
            and
            v.specialty = :specialty
            and
            v.id not in(
                select c.veterinarian.id from Consultation c
                where
                c.date = :date
            )
            order by rand()
            limit 1
        """)
    Veterinarian randomDoctorFreeOnDate(LocalDateTime date, Specialty specialty);

    @Query("SELECT v.active FROM Veterinarian v where v.id =:id")
    Boolean findActiveById(Long id);


}
