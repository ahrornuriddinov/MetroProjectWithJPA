package uz.najot.metroprojectdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.metroprojectdemo.dto.CardDto;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.mapper.CardMapper;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.repository.CardRepository;
import uz.najot.metroprojectdemo.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResMessage getAll(){
        List<CardDto> all = cardService.getAll();
        return ResMessage.getSuccess(all);
    }
    @PostMapping
    public ResMessage save(@RequestBody CardDto cardDto){
        boolean save = cardService.addCard(cardDto);
        if (save){
            return ResMessage.getSuccess(200,"saved");
        }return ResMessage.getSuccess(202,"not saved");
    }
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return cardService.getById(id);
    }

    @PutMapping
    public ResMessage deposit(@RequestParam Integer id,@RequestParam Double cash){
        boolean deposit = cardService.deposit(id, cash);
        if (deposit){
            return ResMessage.getSuccess(200,"succesfully");
        }
        return ResMessage.getSuccess(203,"not succesful");
    }
}
