package uz.pdp.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.p2p.entity.Income;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @GetMapping
    public Result get(@RequestBody Income income) {
        Result result = incomeService.income(income);
        return result;
    }

}
