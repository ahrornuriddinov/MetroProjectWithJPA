package uz.najot.metroprojectdemo.service;

import org.springframework.stereotype.Service;
import uz.najot.metroprojectdemo.model.ResMessage;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public interface HistoryService {
    ResMessage addTransactions(Integer card_id, Integer terminal_id);

    ResMessage getReport(Date fromDate,Date toDate);
//    select s.name,s.balance from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id where h.created_date between ? and ? group by s.name, s.balance order by s.balance desc limit 2
    ResMessage getReportByMoreSpentCard();

    ResMessage getReportByLessSpentCard();

    ResMessage getReportByMoreSpentTerminal();
    ResMessage getReportByLessSpentTerminal();
    ResMessage hisytoryByCardId(Integer id);
}
