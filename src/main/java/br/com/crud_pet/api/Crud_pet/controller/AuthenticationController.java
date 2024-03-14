package br.com.crud_pet.api.Crud_pet.controller;

import br.com.crud_pet.api.Crud_pet.domain.user.AuthenticationDTO;
import br.com.crud_pet.api.Crud_pet.domain.user.RegisterDTO;
import br.com.crud_pet.api.Crud_pet.domain.user.Users;
import br.com.crud_pet.api.Crud_pet.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
        };
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
        Users user = new Users(data.login(), encryptPassword, data.role());

        repository.save(user);

        return ResponseEntity.ok().build();
    }
}
