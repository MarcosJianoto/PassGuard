package com.passguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passguard.entities.UserPasswords;
import com.passguard.enums.Description;

@Repository
public interface UserPasswordsRepository extends JpaRepository<UserPasswords, Integer> {

	boolean existsByEmailAndDescription(String email, Description description);

}
