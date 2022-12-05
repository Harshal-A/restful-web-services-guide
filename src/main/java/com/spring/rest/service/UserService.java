package com.spring.rest.service;

import com.spring.rest.models.User;
import com.spring.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    //Dummy data to start wihout database connection
   /* private static final List<User> users=new ArrayList<>();

    {
        User user1=new User(1,"Harshal", LocalDate.now().minusYears(30));
        User user2=new User(2,"Jim", LocalDate.now().minusYears(25));
        User user3=new User(3,"Pam", LocalDate.now().minusYears(20));

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }*/

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUser(int id){

//        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
//        users.add(user);
       return userRepository.save(user);
    }

    public void deleteUser(int id){
        User checkUser= findUser(id);
        if(checkUser!=null){
//            users.remove(checkUser);
            userRepository.delete(checkUser);
        }
    }
}
