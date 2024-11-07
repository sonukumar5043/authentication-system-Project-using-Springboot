package com.RegisationProject.Login.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.RegisationProject.Login.Model.UserModel;
import java.util.Optional;




@Repository
@EnableJpaRepositories
public interface LoginJpa extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmailAndPassword(String email, String password);
    Optional<UserModel> findByEmail(String email);
    
}
