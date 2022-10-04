package uz.najot.metroprojectdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.entity.Card;
import uz.najot.metroprojectdemo.entity.History;
import uz.najot.metroprojectdemo.entity.Terminal;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.repository.CardRepository;
import uz.najot.metroprojectdemo.repository.HistoryRepository;
import uz.najot.metroprojectdemo.repository.TerminalRepository;
import uz.najot.metroprojectdemo.service.HistoryService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;
    private final CardRepository cardRepository;
    private final TerminalRepository terminalRepository;

    @Override
    public ResMessage addTransactions(Integer card_id, Integer terminal_id) {
        Optional<Card> card = cardRepository.findById(card_id);
        Optional<Terminal> terminal = terminalRepository.findById(terminal_id);
        if (card.isPresent() && terminal.isPresent()){
            if (card.get().getBalance()>=1400D){
                Double balance = card.get().getBalance();
                balance-=1400D;
                card.get().setBalance(balance);
                cardRepository.save(card.get());
                Double balance1 = terminal.get().getStation().getBalance();
                balance1+=1400D;
                terminal.get().getStation().setBalance(balance1);
                terminalRepository.save(terminal.get());
                History history = new History(card.get(), terminal.get());
                historyRepository.save(history);

                return ResMessage.getSuccess(200,"succesfully paid");
            }else {
                return ResMessage.getSuccess(206,"balance is not enough");
            }
        }return ResMessage.getSuccess(203,"terminal_id or card_id is not valid");
    }

    @Override
    public ResMessage getReport(Date fromDate, Date toDate) {
        List<Map<String, Object>> report = historyRepository.findByCreatedDateBetweenStation(fromDate, toDate);
        return ResMessage.getSuccess(report);
    }

    @Override
    public ResMessage getReportByMoreSpentCard() {
        List<Map<String, Object>> byMoreSpentCard = historyRepository.findByMoreSpentCard();
        return ResMessage.getSuccess(byMoreSpentCard);
    }

    @Override
    public ResMessage getReportByLessSpentCard() {
        List<Map<String, Object>> byLessSpentCard = historyRepository.findByLessSpentCard();
        return ResMessage.getSuccess(byLessSpentCard);
    }

    @Override
    public ResMessage getReportByMoreSpentTerminal() {
        List<Map<String, Object>> byMoreSpentTerminal = historyRepository.findByMoreSpentTerminal();
        return ResMessage.getSuccess(byMoreSpentTerminal);
    }

    @Override
    public ResMessage getReportByLessSpentTerminal() {
        List<Map<String, Object>> byLessSpentTerminal = historyRepository.findByLessSpentTerminal();
        return ResMessage.getSuccess(byLessSpentTerminal);
    }

    @Override
    public ResMessage hisytoryByCardId(Integer id) {
        List<Map<String, Object>> maps = historyRepository.historyByCardId(id);
        return ResMessage.getSuccess(maps);
    }
}
