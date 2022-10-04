package uz.najot.metroprojectdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import uz.najot.metroprojectdemo.model.ResMessage;
import uz.najot.metroprojectdemo.service.HistoryService;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final HistoryService historyService;
    @PostMapping
    public ResMessage purchase(@RequestParam Integer card_id,@RequestParam Integer terminal_id){
        return historyService.addTransactions(card_id, terminal_id);
    }

    @GetMapping
    public ResMessage getReport(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate ){
        return historyService.getReport(fromDate,toDate);
    }

    @GetMapping("/morecard")
    public ResMessage getReportByCard(){
        return historyService.getReportByMoreSpentCard();
    }

    @GetMapping("/lesscard")
    public ResMessage getReportByLessSpentCard(){
        return historyService.getReportByLessSpentCard();
    }
    @GetMapping("/moreterminal")
    public ResMessage getReportByMoreSpentTerminal(){
        return historyService.getReportByMoreSpentTerminal();
    }

    @GetMapping("/lessterminal")
    public ResMessage getReportByLessSpentTerminal(){
        return historyService.getReportByLessSpentTerminal();
    }

    @GetMapping("/historycard/{id}")
    public ResMessage getHistoryByCardId(@PathVariable Integer id){
        return historyService.hisytoryByCardId(id);

    }


}
