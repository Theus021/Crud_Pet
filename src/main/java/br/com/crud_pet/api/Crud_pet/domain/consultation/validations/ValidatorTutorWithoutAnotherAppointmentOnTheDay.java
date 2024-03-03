package br.com.crud_pet.api.Crud_pet.domain.consultation.validations;

import br.com.crud_pet.api.Crud_pet.domain.consultation.ConsultationRepository;
import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.domain.tutor.TutorRepository;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.VeterinarianRepository;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorTutorWithoutAnotherAppointmentOnTheDay implements ValidationMethods{

    @Autowired
    private ConsultationRepository repository;

    @Override
    public void validar(RegisterConsultDTO data) {
        var firstHour = data.date().withHour(7);
        var lastHour = data.date().withHour(18);

        var tutorWithoutAnotherAppointmentOnTheDay = repository.existsByTutorId_IdAndDateBetween(data.tutorId(), firstHour, lastHour);
        if (tutorWithoutAnotherAppointmentOnTheDay){
            throw new ValidationDataException("Pet já possui uma consulta agendada nesse dia");
        }
    }
}
