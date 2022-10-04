package uz.najot.metroprojectdemo.dto;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Integer id;
    private String cardnumber;
    private String userPhoneNumber;
    private Double balance;


}
