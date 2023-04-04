package uz.pdp.p2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.p2p.entity.Card;
import uz.pdp.p2p.entity.Income;
import uz.pdp.p2p.entity.OutCome;
import uz.pdp.p2p.model.CardDto;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.repository.CardRepo;
import uz.pdp.p2p.repository.IncomeRepo;
import uz.pdp.p2p.repository.OutComeRepo;

import java.util.List;

@Service
public class OutcomeService {

    @Autowired
    OutComeRepo outComeRepo;
    @Autowired
    IncomeRepo incomeRepo;

    public Result outService(OutCome outCome, CardDto cardDto) {
        double commission = (outCome.getAmount() * 0.01 * 100) / 100.0;
        double totalAmount = outCome.getAmount() + commission;
        if (cardDto.getBalance() < totalAmount) {
            System.out.println("Insufficient funds.");
        }
        if (!outCome.getTo_card_id().equals(cardDto.getNumber())) {
            System.out.println("Invalid recipient card number.");
        }
        return new Result("Outcome", true);
    }

    public Result history(OutCome outCome, Income income) {
        List<OutCome> all = outComeRepo.findAll();
        List<Income> incomeList = incomeRepo.findAll();
        Result history = history((OutCome) all, (Income) incomeList);
        return new Result("History", true, history);
    }


}
