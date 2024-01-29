package com.monitoring.telemetry.repository;

import com.monitoring.telemetry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
