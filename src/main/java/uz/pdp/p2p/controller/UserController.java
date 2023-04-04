package uz.pdp.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.p2p.entity.User;
import uz.pdp.p2p.model.Result;
import uz.pdp.p2p.model.UserDto;
import uz.pdp.p2p.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> all() {
        List<User> allUserList = userService.allUserList();
        return allUserList;
    }

    @GetMapping("/{id}")
    public User getId(@PathVariable Integer id) {
        User idUser = userService.getIdUser(id);
        return idUser;
    }

    @PostMapping
    public Result add(@RequestBody UserDto userDto) {
        Result result = userService.addUser(userDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody UserDto userDto) {
        Result result = userService.editUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = userService.deletedUser(id);
        return result;
    }
}
