package com.passguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passguard.entities.UserPasswords;

@Repository
public interface UserPasswordsRepository extends JpaRepository<UserPasswords, Integer> {

}
