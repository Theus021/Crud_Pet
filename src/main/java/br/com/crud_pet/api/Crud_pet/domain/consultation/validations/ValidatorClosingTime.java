package br.com.crud_pet.api.Crud_pet.domain.consultation.validations;

import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidatorClosingTime implements ValidationMethods{
    @Override
    public void validar(RegisterConsultDTO data) {
        var sunday = data.date().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var closingTime = data.date().getHour() > 18;
        var openTime = data.date().getHour() < 7;

        if (sunday || closingTime || openTime){
            throw new ValidationDataException("Consulta fora do horário disponivel");
        }
    }
}
