package uz.najot.metroprojectdemo.mapper;

import org.mapstruct.Mapper;
import uz.najot.metroprojectdemo.dto.CardDto;
import uz.najot.metroprojectdemo.dto.StationDto;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.entity.Station;

import java.util.List;

public class StationMapper {

    public static Station toEntity(StationDto stationDto){
        return new Station(stationDto.getName(),stationDto.getBalance());
    }
    public static StationDto toDto(Station station){
        return new StationDto(station.getId(),station.getName(),station.getBalance());
    }
}
