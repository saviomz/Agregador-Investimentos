package com.example.AgregadorInvestimentos.Controller;


import com.example.AgregadorInvestimentos.Entity.User;
import com.example.AgregadorInvestimentos.UserRepository;
import com.example.AgregadorInvestimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // metodo htpp para fazer a criação de usuário
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){
        //DTOS são objetos que conseguimos utilizar para especificar a transferencia do banco de dados para aplicação.
        userService.createUser(createUserDTO);
        return null;
    }

    @Autowired
    private UserRepository userRepository;


    // Endpoint GET para obter um usuário específico pelo ID
    @GetMapping("/{id}") // Mapeia uma requisição HTTP GET para o caminho "/users/{id}", onde {id} é uma variável de caminho
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id); // Tenta encontrar o usuário pelo ID

        // Retorna 200 OK se o usuário for encontrado, ou 404 caso contrário
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
