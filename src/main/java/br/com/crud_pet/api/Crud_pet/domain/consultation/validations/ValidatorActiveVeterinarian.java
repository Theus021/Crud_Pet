package br.com.crud_pet.api.Crud_pet.domain.consultation.validations;

import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.VeterinarianRepository;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorActiveVeterinarian implements ValidationMethods {

    @Autowired
    private VeterinarianRepository repository;


    @Override
    public void validar(RegisterConsultDTO data) {
        if (data.veterinarianId() == null){
            return;
        }

        var querryActiveVet = repository.findActiveById(data.veterinarianId());
        if (!querryActiveVet) {
            throw new ValidationDataException("Consulta não pode ser agendada para esse Veterinário");
        }
    }
}
