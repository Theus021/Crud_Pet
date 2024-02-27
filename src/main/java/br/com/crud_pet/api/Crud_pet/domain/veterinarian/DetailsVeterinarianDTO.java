package br.com.crud_pet.api.Crud_pet.domain.veterinarian;

import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;

public record DetailsVeterinarianDTO(Long id, String name, String email, String crm, String telephone, Specialty specialty, Address address) {

    public  DetailsVeterinarianDTO(Veterinarian vet){
        this(vet.getId(), vet.getName(), vet.getEmail(), vet.getCrm(), vet.getTelephone(), vet.getSpecialty(), vet.getAddress());
    }
}
