package com.myself.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myself.Model.LoginHistory;

@Repository
public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Integer> {

}