package br.com.crud_pet.api.Crud_pet.domain.addresss;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(AddressDataDTO address){
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.city = address.city();
        this.uf = address.uf();
        this.complement = address.complement();
        this.number = address.number();
    }

    public void updataInformations(AddressDataDTO data) {
        if (data.neighborhood() != null){
            this.neighborhood = data.neighborhood();
        }

        if (data.cep() != null){
            this.cep = data.cep();
        }

        if (data.city() != null){
            this.city = data.city();
        }

        if (data.uf() != null){
            this.uf = data.uf();
        }

        if (data.complement() != null){
            this.complement = data.complement();
        }

        if (data.number() != null){
            this.number = data.number();
        }
    }
}
