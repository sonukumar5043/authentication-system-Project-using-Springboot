package com.RegisationProject.Login.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RegisationProject.Login.Model.UserModel;
import com.RegisationProject.Login.Services.ServicesLayer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private  ServicesLayer layer;



    @PostMapping(path = "/save")
    public  String save(@RequestBody UserModel model){
       layer.add(model);
    return "save sucefulley";
}
  @GetMapping(path = "/get")
  public List<UserModel>getMethodName() {
      return layer.get();
  }
  @GetMapping(path = "/login")
  public String getMethodName(@RequestParam String email,@RequestParam String password) {
    return layer.check(email,password);
  }
  
  @PutMapping(path = "/update/{email}/{password}")
  public String updateUser(@PathVariable String email, @PathVariable String password, @RequestBody UserModel entity) {
         return layer.update(email,password,entity);
              
           }

           @DeleteMapping("/delAccount/{email}")
           public String delete(@PathVariable String email){
            return layer.delete(email);
           }
}
