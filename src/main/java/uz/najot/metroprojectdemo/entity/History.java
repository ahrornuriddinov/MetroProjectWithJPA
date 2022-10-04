package uz.najot.metroprojectdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Card card;
    @ManyToOne(fetch = FetchType.EAGER)
    private Terminal terminal;
    @CreationTimestamp
    private Date createdDate;

    public History(Card card, Terminal terminal) {
        this.card = card;
        this.terminal = terminal;
    }
}
