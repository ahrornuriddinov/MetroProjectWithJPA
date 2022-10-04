package uz.najot.metroprojectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najot.metroprojectdemo.entity.History;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query(value = "select s.id,s.name,s.balance from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id where h.created_date between ? and ? group by s.name, s.balance, s.id order by s.balance desc limit 2",nativeQuery = true)
    List<Map<String,Object>> findByCreatedDateBetweenStation(Date fromDate, Date toDate);

    @Query(value = "select c.id,c.card_number from history h left join card c on c.id = h.card_id group by h.card_id, c.card_number, c.id order by count(h.card_id) desc limit 1",nativeQuery = true)
    List<Map<String,Object>> findByMoreSpentCard();

    @Query(value = "select c.id,c.card_number from history h left join card c on c.id = h.card_id group by h.card_id, c.card_number, c.id order by count(h.card_id) asc limit 1",nativeQuery = true)
    List<Map<String,Object>> findByLessSpentCard();
    @Query(value = "select t.id,count(h.terminal_id) from history h left join terminal t on t.id = h.terminal_id group by h.terminal_id,t.id order by count(h.terminal_id) desc limit 1",nativeQuery = true)
    List<Map<String,Object>> findByMoreSpentTerminal();

    @Query(value = "select t.id,count(h.terminal_id) from history h left join terminal t on t.id = h.terminal_id group by h.terminal_id,t.id order by count(h.terminal_id) asc limit 1",nativeQuery = true)
    List<Map<String,Object>> findByLessSpentTerminal();

    @Query(value = "select h.card_id,s.name,(s.balance) from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id where card_id=? group by s.name, h.card_id, s.balance",nativeQuery = true)
    List<Map<String,Object>> historyByCardId(Integer id);
}

