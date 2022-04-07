package com.ispan.springbootdemo.repository;

import com.ispan.springbootdemo.Entity.WorkMessages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkMessagesRepository extends JpaRepository<WorkMessages, Integer> {

  public WorkMessages findFirstByOrderByAddedDesc();
}
