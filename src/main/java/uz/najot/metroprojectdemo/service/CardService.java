package uz.najot.metroprojectdemo.service;

import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.CardDto;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.model.ResMessage;

import java.util.List;

@Service
public interface CardService {
    boolean addCard(CardDto cardDto);
    List<CardDto> getAll();
    ResMessage getById(Integer id);

    boolean deposit(Integer id,Double cash);
}
