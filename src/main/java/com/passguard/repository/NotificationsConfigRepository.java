package com.passguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passguard.entities.NotificationsConfig;

@Repository
public interface NotificationsConfigRepository extends JpaRepository<NotificationsConfig, Integer> {

	boolean existsById(Integer id);

}
