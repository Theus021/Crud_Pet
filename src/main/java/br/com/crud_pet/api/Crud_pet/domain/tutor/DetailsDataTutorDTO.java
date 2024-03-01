package br.com.crud_pet.api.Crud_pet.domain.tutor;

import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;

import java.util.List;

public record DetailsDataTutorDTO(String tutor, String pet, String age, String weight,String telephone, String email ,Address address) {

    public DetailsDataTutorDTO(Tutor tutor){
        this(tutor.getTutor(), tutor.getPet(), tutor.getAge(), tutor.getWeight(), tutor.getTelephone(), tutor.getEmail(), tutor.getAddress());
    }
}
