package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name = "usuarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String telefone;



    public String getPassword() {
        return senha;
    }


    public String getUsername() {
        return email;
    }
}