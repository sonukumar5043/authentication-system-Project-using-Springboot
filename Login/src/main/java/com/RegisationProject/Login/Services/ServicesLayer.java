package com.RegisationProject.Login.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RegisationProject.Login.Model.UserModel;
import com.RegisationProject.Login.Repository.LoginJpa;
@Service
public class ServicesLayer  {
        @Autowired
        private LoginJpa jpa;
        public void add(UserModel model) {
              jpa.save(model);
        }
        public List<UserModel> get() {
            return jpa.findAll();
      }
       
        public String check(String email, String password) {
          Optional <UserModel> data=jpa.findByEmailAndPassword(email, password);
      if(data.isPresent()){
        return "user authenticated";
      }
      return "invalid email or password";
      
    }
        public String update(String email,String password, UserModel entity) {
           Optional<UserModel> data=jpa.findByEmailAndPassword(email, password);
           if(data.isEmpty()){
            return "not found";
           }
           UserModel existingUser = data.get();
           existingUser.setEmail(entity.getEmail());
           existingUser.setPassword(entity.getPassword());
           jpa.save(existingUser);
           return "succesfulley update to db";
            
        }
        public String delete(String email) {
             Optional<UserModel> data=jpa.findByEmail(email);
             if(data.isEmpty()){
                return "invalid operation";
             }
             jpa.delete(data.get());
             return "succesfulley";
        }
}
