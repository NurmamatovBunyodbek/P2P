package uz.pdp.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.p2p.entity.Card;
import uz.pdp.p2p.model.CardDto;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.service.CardService;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping
    public List<Card> cardList() {
        List<Card> list = cardService.cardList();
        return list;
    }

    @PostMapping
    public Result add(@RequestBody CardDto cardDto) {
        Result result = cardService.addCard(cardDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = cardService.deletedCard(id);
        return result;
    }


}
