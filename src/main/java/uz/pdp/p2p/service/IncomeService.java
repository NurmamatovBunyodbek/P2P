package uz.pdp.p2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.p2p.entity.Income;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.repository.IncomeRepo;

@Service
public class IncomeService {

    @Autowired
    IncomeRepo incomeRepo;

    public Result income(Income income) {
        Income income1 = new Income();
        income1.setFrom_card_id(income.getFrom_card_id());
        income1.setTo_card_id(income.getTo_card_id());
        income1.setAmount(income.getAmount());
        income1.setDate(income.getDate());
        incomeRepo.save(income1);
        return new Result("income", true);
    }
}
