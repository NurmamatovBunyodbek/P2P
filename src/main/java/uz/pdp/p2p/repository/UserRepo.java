package uz.pdp.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.p2p.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {


    boolean existsByPhoneNumber(String phoneNumber);

}
