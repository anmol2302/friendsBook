package com.techprimers.springbootneo4jexample1.service;

import com.techprimers.springbootneo4jexample1.model.User;
import com.techprimers.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAllUsers();
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public boolean addFriend(long person1Id,long person2Id){
try {
    User person1Obj = userRepository.findOne(person1Id);
    User person2Obj = userRepository.findOne(person2Id);
    person1Obj.getFriends().add(person2Obj.getName());
    person2Obj.getFriends().add(person1Obj.getName());
    userRepository.save(person1Obj);
    userRepository.save(person2Obj);
    System.out.println(userRepository.exists(person1Id));
    System.out.println(userRepository.exists((long)5));
    System.out.println(userRepository.findOne((long)3).getName());
    System.out.println(userRepository.findOne(person1Id).getName());
}
catch(Exception e){
    e.printStackTrace();
    return false;
}
return true;
    }


}
