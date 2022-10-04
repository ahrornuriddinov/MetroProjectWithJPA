package uz.najot.metroprojectdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.CardDto;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.mapper.CardMapper;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.repository.CardRepository;
import uz.najot.metroprojectdemo.service.CardService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;


    @Override
    public boolean addCard(CardDto cardDto) {
        Card card = CardMapper.toEntity(cardDto);
        Card save = cardRepository.save(card);
        if (save.getId()>0){
        return true;}
        return false;
    }

    @Override
    public List<CardDto> getAll() {
        List<Card> all = cardRepository.findAll();
        List<CardDto> cardDtos = new LinkedList<>();
        for (Card card:all) {
            cardDtos.add(new CardDto(card.getId(),card.getCardNumber(),card.getUserPhoneNumber(),card.getBalance()));
        }
        return cardDtos;

    }

    @Override
    public ResMessage getById(Integer id) {
        Optional<Card> card = cardRepository.findById(id);
        if (card.isPresent()){
            return ResMessage.getSuccess(card);
        }return ResMessage.getSuccess(205,"id is invalid");
    }

    @Override
    public boolean deposit(Integer id, Double cash) {
        Optional<Card> byId = cardRepository.findById(id);
        if (byId.isPresent()){
            Double balance = byId.get().getBalance();
            balance+=cash;
            byId.get().setBalance(balance);
            Card save = cardRepository.save(byId.get());
            return true;
        }
        return false;

    }
}
