package br.com.crud_pet.api.Crud_pet.infra.service;

import br.com.crud_pet.api.Crud_pet.domain.consultation.Consultation;
import br.com.crud_pet.api.Crud_pet.domain.consultation.ConsultationRepository;
import br.com.crud_pet.api.Crud_pet.domain.consultation.DetailsConsultationDTO;
import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.domain.consultation.validations.ValidationMethods;
import br.com.crud_pet.api.Crud_pet.domain.tutor.TutorRepository;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.Veterinarian;
import br.com.crud_pet.api.Crud_pet.domain.veterinarian.VeterinarianRepository;
import br.com.crud_pet.api.Crud_pet.infra.service.excpetions.ValidationDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Autowired
    private List<ValidationMethods> validator;

    public SchedulerService() {
    }

    public DetailsConsultationDTO toSchedule(RegisterConsultDTO data) {
        if (!tutorRepository.existsById(data.tutorId())){
            throw new ValidationDataException("Id do paciente não existe !");
        }
        if (!veterinarianRepository.existsById(data.veterinarianId())){
            throw new ValidationDataException("Id do veterinario não existente !");
        }

        validator.forEach( v -> v.validar(data));

        var tutor = tutorRepository.getReferenceById(data.tutorId());
        var veterinarian = randomVet(data);

        var consultation = new Consultation(null, veterinarian, tutor, data.date());
        consultationRepository.save(consultation);

        return new DetailsConsultationDTO(consultation);
    }

    private Veterinarian randomVet(RegisterConsultDTO data) {
        if (data.veterinarianId() != null){
            return veterinarianRepository.getReferenceById(data.veterinarianId());
        }
        if (data.specialty() == null){
            throw new ValidationDataException("Campo da especialidade é obrigatório");
        }

        return veterinarianRepository.randomDoctorFreeOnDate(data.date(), data.specialty());
    }
}
