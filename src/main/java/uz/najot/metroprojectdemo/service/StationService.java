package uz.najot.metroprojectdemo.service;

import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.StationDto;
import uz.najot.metroprojectdemo.entity.Station;
import uz.najot.metroprojectdemo.model.ResMessage;

import java.util.List;

@Service
public interface StationService {

    boolean addStation(StationDto stationDto);
    List<StationDto> getAll();
    ResMessage getById(Integer id);
}
