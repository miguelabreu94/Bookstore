package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser{
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole role;

    public AppUser(String email, String password, AppUserRole role){
        super();
        this.email = email;
        this.password = password;
        this.role = role;
    }



}
