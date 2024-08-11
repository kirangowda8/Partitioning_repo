package com.partitioning.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.partitioning.users.entity.Users;
import com.partitioning.users.entity.compositekey.UsersCompKey;

import jakarta.transaction.Transactional;

@Repository
public interface  UsersRepository  extends JpaRepository<Users, UsersCompKey>{

   Users findByName(String name);
   
   Users findByUsersCompKeyId(Integer id);
   
   @Transactional
   @Query(value = "SELECT nextVal('user_seq_id')", nativeQuery = true)
   Long getUserId();

}
