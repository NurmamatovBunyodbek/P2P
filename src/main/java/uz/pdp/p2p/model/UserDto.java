package uz.pdp.p2p.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;

}
