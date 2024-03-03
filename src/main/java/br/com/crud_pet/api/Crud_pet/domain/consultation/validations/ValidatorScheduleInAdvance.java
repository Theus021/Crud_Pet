package br.com.crud_pet.api.Crud_pet.domain.consultation.validations;

import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidatorScheduleInAdvance implements ValidationMethods{
    @Override
    public void validar(RegisterConsultDTO data) {
        var schedulingTime = data.date();
        var currentTime = LocalDateTime.now();
        var differceMinuts = Duration.between(schedulingTime, currentTime).toMinutes();

        if (differceMinuts < 30){
            throw new ValidationDataException("A consulta só pode ser cancelada com mais de 30 minutos de antecedencia");
        }
    }
}
