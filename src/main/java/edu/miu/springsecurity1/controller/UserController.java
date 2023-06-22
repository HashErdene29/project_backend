package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.entity.dto.UserDto;
import edu.miu.springsecurity1.entity.dto.UserListDto;
import edu.miu.springsecurity1.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }


    @PostMapping
    public void save(@RequestBody User u) {
        userService.save(u);
//        return userService.addUser(userDto.getEmail(), userDto.getPassword(), userDto.getFirstname(), userDto.getLastname(), userDto.getRole_id());
    }

    @GetMapping("/change/{id}/{status}")
    public String changeStatus(@PathVariable int id, @PathVariable boolean status){
        return userService.changeStatus(id, status);
    }

    @GetMapping("/{id}/req-approval")
    public String sendReqApproval(@PathVariable int id){
        return userService.sendReqApproval(id);
    }

    @GetMapping("/{id}/approval-list")
    public List<User> getUsersApprovalList(@PathVariable int id){
        return userService.getApprovalUsersList(id);
    }
}
