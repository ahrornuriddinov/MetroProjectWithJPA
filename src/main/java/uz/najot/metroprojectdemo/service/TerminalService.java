package uz.najot.metroprojectdemo.service;

import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.StationDto;
import uz.najot.metroprojectdemo.dto.TerminalDto;
import uz.najot.metroprojectdemo.entity.Station;
import uz.najot.metroprojectdemo.entity.Terminal;
import uz.najot.metroprojectdemo.model.ResMessage;

import java.util.List;

@Service
public interface TerminalService {
    boolean addTerminal(Integer station_id);
    List<Terminal> getAll();
    ResMessage getById(Integer id);
}
