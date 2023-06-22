package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.Property;
import edu.miu.springsecurity1.entity.Role;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.entity.dto.SavedDto;
import edu.miu.springsecurity1.entity.dto.UserDto;
import edu.miu.springsecurity1.entity.dto.UserListDto;
import edu.miu.springsecurity1.repository.RoleRepo;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void save(User p) {
        userRepo.save(p);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDto getById(int id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }
    @Override
    public String changeStatus(int id, boolean status){
        int i = userRepo.updateStatusById(id, status ? 1 : 0);
        if(i == 0) {
            return "Failed to complete this request. User should have sent a request to change the status";
        } else {
            return "Successfully completed";
        }
    }

    @Override
    public String sendReqApproval(int id){
        int i = userRepo.updateReqStatus(id);
        if(i == 0) {
            return "Failed to complete this request.";
        } else {
            return "Successfully completed";
        }
    }

    @Override
    public List<User> getApprovalUsersList(int id){
        return userRepo.findAllUsersSentApproval(id);
    }

    public List<UserDto> getAll() {
        var users = userRepo.findAll();
        return
                users
                        .stream()
                        .map( p -> modelMapper.map(p,UserDto.class))
                        .collect(Collectors.toList());
    }
}
