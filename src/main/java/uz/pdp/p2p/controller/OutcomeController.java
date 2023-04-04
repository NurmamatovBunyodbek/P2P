package uz.pdp.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.p2p.entity.Income;
import uz.pdp.p2p.entity.OutCome;
import uz.pdp.p2p.model.CardDto;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.service.OutcomeService;

@RestController
@RequestMapping("/outcome")
public class OutcomeController {

    @Autowired
    OutcomeService outcomeService;

    @GetMapping
    public Result out(OutCome outCome, CardDto cardDto) {
        Result result = outcomeService.outService(outCome, cardDto);
        return result;
    }

    @GetMapping("/history")

    public Result showHistory(@RequestBody OutCome outCome, @RequestBody Income income) {
        Result history = outcomeService.history(outCome, income);
        return history;
    }
}
