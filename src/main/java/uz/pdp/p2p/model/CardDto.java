package uz.pdp.p2p.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CardDto {


    private String username;
    private String number;
    private Date expireDate;
   private Double balance=0.0;

}
