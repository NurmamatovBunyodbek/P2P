package uz.pdp.p2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.p2p.entity.Card;
import uz.pdp.p2p.model.CardDto;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.repository.CardRepo;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;

    public List<Card> cardList() {
        List<Card> list = cardRepo.findAll();
        return list;
    }

    public Result addCard(CardDto cardDto) {
        Card card = new Card();
        card.setUsername(cardDto.getUsername());
        card.setNumber(cardDto.getNumber());
        card.setExpireDate(cardDto.getExpireDate());
        cardRepo.save(card);
        return new Result("Card added", true);
    }

    public Result deletedCard(Integer id) {
        cardRepo.deleteById(id);
        return new Result("Card deleted", true);
    }

}
