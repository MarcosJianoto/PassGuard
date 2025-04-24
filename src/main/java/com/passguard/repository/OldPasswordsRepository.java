package com.passguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passguard.entities.OldPasswords;

@Repository
public interface OldPasswordsRepository extends JpaRepository<OldPasswords, Integer> {

}
