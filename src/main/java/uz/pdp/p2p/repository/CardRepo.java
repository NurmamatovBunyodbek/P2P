package uz.pdp.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.p2p.entity.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {

       boolean findByBalance(Double balance);

}
