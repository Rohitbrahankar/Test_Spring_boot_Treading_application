package com.example.demo.Repo;

import com.example.demo.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<users, Long> {
}
