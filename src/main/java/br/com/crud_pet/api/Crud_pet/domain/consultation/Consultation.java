package br.com.crud_pet.api.Crud_pet.domain.consultation;

import br.com.crud_pet.api.Crud_pet.domain.tutor.Tutor;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.Veterinarian;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Consultations")
@Entity(name = "Consultation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutorId;

    private LocalDateTime date;



}
