package br.com.crud_pet.api.Crud_pet.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
