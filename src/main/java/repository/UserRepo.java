package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.User;




public interface UserRepo extends JpaRepository <User ,Integer>{

}
