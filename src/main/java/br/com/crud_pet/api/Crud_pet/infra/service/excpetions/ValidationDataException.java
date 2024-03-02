package br.com.crud_pet.api.Crud_pet.infra.service.excpetions;

public class ValidationDataException extends RuntimeException {
    public ValidationDataException(String message){
        super(message);
    }
}
