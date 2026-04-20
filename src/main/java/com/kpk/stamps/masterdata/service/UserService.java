package com.kpk.stamps.masterdata.service;


import com.kpk.stamps.entity.Concern;
import com.kpk.stamps.masterdata.dto.UserDTO;
import com.kpk.stamps.masterdata.entity.Department;
import com.kpk.stamps.masterdata.entity.User;
import com.kpk.stamps.masterdata.repository.DepartmentRepository;
import com.kpk.stamps.masterdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public User createUser(Long departmentId,UserDTO userDTO){
        Department department=departmentRepository.findById(departmentId)
                .orElseThrow(()->new RuntimeException("Department not found"));


        User user=new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setDepartment(department);
        user.setEmployeeId(generateUserId());

        userRepository.save(user);

        return user;


    }

    private String generateUserId() {

        Optional<User> lastUser =
                userRepository.findTopByOrderByIdDesc();

        if (lastUser.isEmpty()) {
            return "EMP-001";
        }

        String lastNumber = lastUser.get().getEmployeeId();
        int number = Integer.parseInt(lastNumber.split("-")[1]);

        return String.format("EMP-%03d", number + 1);
    }

    public List<User> getAllUsers(){
        List<User> users=userRepository.findAll();

        return users;
    }

    public List<User> getAllUsersByDepartment(Long departmentId){
        List<User> users=userRepository.findByDepartmentId(departmentId);

        return users;
    }

    public User updateUser(Long userId,UserDTO userDTO){

        User user=userRepository.findById(userId)
                        .orElseThrow(()->new RuntimeException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());

        userRepository.save(user);

        return user;

    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

}
