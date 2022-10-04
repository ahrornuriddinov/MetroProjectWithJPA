package uz.najot.metroprojectdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.StationDto;
import uz.najot.metroprojectdemo.entity.Station;
import uz.najot.metroprojectdemo.mapper.StationMapper;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.repository.StationRepository;
import uz.najot.metroprojectdemo.service.StationService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    @Override
    public boolean addStation(StationDto stationDto) {
        Station station = StationMapper.toEntity(stationDto);
        Station save = stationRepository.save(station);
        if (!(save.getName()==null || save.getBalance()==null)){
            return true;
        }
        return false;
    }

    @Override
    public List<StationDto> getAll() {
        List<Station> all = stationRepository.findAll();
        List<StationDto> stationDtos = new LinkedList<>();
        for (Station station:all) {
            stationDtos.add(new StationDto(station.getId(),station.getName(), station.getBalance()));
        }
        return stationDtos;
    }

    @Override
    public ResMessage getById(Integer id) {
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()){
            return ResMessage.getSuccess(station);
        }return ResMessage.getSuccess(205,"id is invalid");
    }
}
