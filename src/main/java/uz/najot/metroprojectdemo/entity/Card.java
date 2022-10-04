package uz.najot.metroprojectdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardNumber;
    private String userPhoneNumber;
    private Double balance;
    @CreationTimestamp
    private Date createdDate;


    public Card(String cardNumber, String userPhoneNumber, Double balance) {
        this.cardNumber = cardNumber;
        this.userPhoneNumber = userPhoneNumber;
        this.balance = balance;
    }
}
