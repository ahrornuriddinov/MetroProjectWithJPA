package uz.najot.metroprojectdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.metroprojectdemo.entity.Terminal;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.service.TerminalService;

import java.util.List;

@RestController
@RequestMapping("/terminal")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalService terminalService;
    @PostMapping("{station_id}")
    public ResMessage addTerminal(@PathVariable Integer station_id){
        boolean b = terminalService.addTerminal(station_id);
        if (b){
            return ResMessage.getSuccess(200,"saved");
        }return ResMessage.getSuccess(205,"id is invalid");
    }
    @GetMapping
    public ResMessage getAll(){
        List<Terminal> all = terminalService.getAll();
        return ResMessage.getSuccess(all);
    }
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return terminalService.getById(id);
    }
}
