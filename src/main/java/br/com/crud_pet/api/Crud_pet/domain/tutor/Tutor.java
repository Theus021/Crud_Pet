package br.com.crud_pet.api.Crud_pet.domain.tutor;

import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Tutors")
@Entity(name = "Tutor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tutor;
    private String pet;
    private String age;
    private String weight;
    private String telephone;
    private String email;

    @Embedded
    private Address address;

    public Tutor(RegisterDataTutorDto data){
        this.tutor = data.tutor();
        this.pet = data.pet();
        this.age = data.age();
        this.weight = data.weight();
        this.telephone = data.telephone();
        this.email = data.email();
        this.address = new Address(data.address());
    }


    public void updateinf(UpdateTutorDto data) {
        if (data.tutor() != null){
            this.tutor = data.tutor();
        }
        if(data.pet() != null){
            this.pet = data.pet();
        }
        if (data.age() != null){
            this.age = data.age();
        }
        if (data.weight() != null){
            this.weight = data.weight();
        }
        if(data.telephone() != null){
            this.telephone = data.telephone();
        }
        if (data.email() != null){
            this.email = data.email();
        }
        if (data.address() != null){
            this.address.updataInformations(data.address());
        }
    }


}
