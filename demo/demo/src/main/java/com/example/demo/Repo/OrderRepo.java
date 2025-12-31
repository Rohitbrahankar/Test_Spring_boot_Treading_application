package com.example.demo.Repo;

import com.example.demo.Entity.order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.order;

import java.util.List;

public interface OrderRepo extends JpaRepository<order, Long> {

//    Page<order> findByUserId(Long userId, Pageable pageable);
List<order> findByUserId(Long userId);
}
