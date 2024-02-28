package br.com.crud_pet.api.Crud_pet.domain.veterinarian;


import br.com.crud_pet.api.Crud_pet.domain.addresss.Address;
import br.com.crud_pet.api.Crud_pet.domain.addresss.AddressData;
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

    @Enumerated
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active;


    public Veterinarian(RegisterDataVet data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }


}
