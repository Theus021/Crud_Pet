package br.com.crud_pet.api.Crud_pet.domain.veterinarian;


import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Veterinarians")
@Entity(name = "Veterinarian")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active = true;


    public Veterinarian(RegisterDataVetDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updataInfoVet(UpdateVeterinarianDTO data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if(data.email() != null){
            this.email = data.email();
        }
        if (data.telephone() != null){
            this.telephone = data.telephone();
        }
        if (data.address() != null){
            this.address.updataInformations(data.address());
        }
    }
}
