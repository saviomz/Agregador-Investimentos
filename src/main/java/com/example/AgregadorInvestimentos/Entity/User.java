package com.example.AgregadorInvestimentos.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Password")
    private String password;


    // O timestamp de criação é automaticamente atribuído quando o registro é persistido pela primeira vez.
    // Ele indica o momento exato em que a entidade foi criada no banco de dados.
    // O valor será preenchido apenas uma vez, no momento da inserção, e não será alterado posteriormente.
    @CreationTimestamp //
    private Instant creationTimestamp;


    // O timestamp de atualização é automaticamente atribuído toda vez que a entidade for atualizada.
    // Ele registra o momento exato em que a entidade foi modificada no banco de dados.
    // Sempre que a entidade for atualizada (via atualização de algum campo), esse timestamp será alterado.
    @UpdateTimestamp
    private Instant updateTimestamp;


    public User(Object o, String username, String email, String password, Instant nowed, Instant now){

    }

    public User(UUID userId, String username, String email, String password, Instant creationTimestamp, Instant updateTimestamp) {
        this.userId = userId;
        this.username = username;
        this.Email = email;
        this.password = password;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    //getter e setter
    public UUID getId(){
        return userId;
    }

    public void setId(UUID id) {
        this.userId = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
