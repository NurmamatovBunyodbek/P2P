package uz.pdp.p2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.p2p.entity.User;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.model.UserDto;
import uz.pdp.p2p.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> allUserList() {
        List<User> all = userRepo.findAll();
        return all;
    }

    public User getIdUser(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        User user = optionalUser.get();
        return user;
    }

    public Result addUser(UserDto userDto) {
        boolean existsByPhoneNumber = userRepo.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new Result("phone number already registered", true);
        }
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return new Result("User added", true);
    }

    public Result editUser(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setPassword(userDto.getPassword());
            userRepo.save(user);
            return new Result("User editing", true);
        }
        return new Result("User not found", false);
    }

    public Result deletedUser(Integer id) {
        userRepo.deleteById(id);
        return new Result("User deleted", true);
    }


}
