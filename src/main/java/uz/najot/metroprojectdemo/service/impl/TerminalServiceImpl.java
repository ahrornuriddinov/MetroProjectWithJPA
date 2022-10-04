package uz.najot.metroprojectdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.dto.TerminalDto;
import uz.najot.metroprojectdemo.entity.Station;
import uz.najot.metroprojectdemo.entity.Terminal;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.repository.StationRepository;
import uz.najot.metroprojectdemo.repository.TerminalRepository;
import uz.najot.metroprojectdemo.service.TerminalService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerminalServiceImpl implements TerminalService {

    private final TerminalRepository terminalRepository;
    private final StationRepository stationRepository;

    @Override
    public boolean addTerminal(Integer station_id) {

        Optional<Station> station = stationRepository.findById(station_id);
        if (station.isPresent()){
            Terminal terminal = new Terminal(station.get());
            terminalRepository.save(terminal);
            return true;
        }
        return false;

    }

    @Override
    public List<Terminal> getAll() {
        List<Terminal> all = terminalRepository.findAll();
        return all;
    }

    @Override
    public ResMessage getById(Integer id) {
        Optional<Terminal> terminal = terminalRepository.findById(id);
        if (terminal.isPresent()){
            return ResMessage.getSuccess(terminal.get());
        }
        return ResMessage.getSuccess(205,"id is invalid");

    }
}
