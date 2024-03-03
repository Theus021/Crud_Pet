package br.com.crud_pet.api.Crud_pet.domain.consultation.validations;

import br.com.crud_pet.api.Crud_pet.domain.consultation.ConsultationRepository;
import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorVeterinarianWithAnotherAppointmentAtTheSameTime implements ValidationMethods{

    @Autowired
    private ConsultationRepository repository;


    @Override
    public void validar(RegisterConsultDTO data) {
        var veterinarianHasAnotherAppointmentAtTheSameTime = repository.existsByVeterinarianIdAndDate(data.veterinarianId(), data.date());
        if (veterinarianHasAnotherAppointmentAtTheSameTime){
            throw new ValidationDataException("Veterinarian já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
