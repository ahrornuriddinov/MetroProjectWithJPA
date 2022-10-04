package uz.najot.metroprojectdemo.mapper;

import org.mapstruct.Mapper;
import uz.najot.metroprojectdemo.dto.CardDto;
import uz.najot.metroprojectdemo.entity.Card;

import java.util.List;

public class CardMapper {
    public static Card toEntity(CardDto cardDto) {
        return new Card(cardDto.getCardnumber(),cardDto.getUserPhoneNumber(),
                cardDto.getBalance());
    }
    public static CardDto toDto(Card card){
        return new CardDto(card.getId(),card.getCardNumber(),card.getUserPhoneNumber(),card.getBalance());
    }
}
