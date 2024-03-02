package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.consultation.RegisterConsultDTO;
import br.com.crud_pet.api.Crud_pet.infra.service.SchedulerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private SchedulerService schedule;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterConsultDTO data){
        var dto = schedule.toSchedule(data);
        return ResponseEntity.ok(dto);
    }
}
