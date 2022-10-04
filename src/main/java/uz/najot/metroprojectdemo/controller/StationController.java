package uz.najot.metroprojectdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.metroprojectdemo.dto.StationDto;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.service.StationService;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class StationController {
    private final StationService stationService;

    @PostMapping
    public ResMessage addStation(@RequestBody StationDto stationDto){
        boolean b = stationService.addStation(stationDto);
        if (b){
        return ResMessage.getSuccess(200,"saved");
    }return ResMessage.getSuccess(202,"not saved");
    }
    @GetMapping
    public ResMessage getAll(){
        return  ResMessage.getSuccess(stationService.getAll());
    }
    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return stationService.getById(id);
    }
}
