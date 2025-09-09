package com.excelr.CollegeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.CollegeManagementSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
        public User findByUserName(String user);
}
