package com.techprimers.springbootneo4jexample1.service;

import com.techprimers.springbootneo4jexample1.model.User;
import com.techprimers.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
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
    person1Obj.getFriends().add(person2Obj.getId());
    person2Obj.getFriends().add(person1Obj.getId());
    userRepository.save(person1Obj);
    userRepository.save(person2Obj);
}



catch(Exception e){
    e.printStackTrace();
    return false;
}
return true;
    }
    public User getBYId(long id){


        try {
            return userRepository.getByid(id);
        }
        catch(Exception e){

            e.printStackTrace();
        }
return null;
    }



    public boolean valdiateUserEmail(String emailToBeValidated){

        boolean isFound=false;
        try{


            System.out.println(Arrays.toString(userRepository.getAllUserEmails().toArray()));

            isFound=userRepository.getAllUserEmails().contains(emailToBeValidated);

        }
        catch (Exception e){
            return false;
        }

        return isFound;
    }

    public boolean deleteAllUsers(){

        try {
             userRepository.deleteAllUsers();
             return true;
        }
        catch(Exception e){

            e.printStackTrace();
            return false;
        }

    }

}
