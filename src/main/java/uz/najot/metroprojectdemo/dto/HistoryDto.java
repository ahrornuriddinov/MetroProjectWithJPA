package uz.najot.metroprojectdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.entity.Terminal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {
    private Integer id;
    private Card card;
    private Terminal terminal;

}
