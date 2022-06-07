package com.myself.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myself.Model.CheckOutPrice;
@Repository
public interface CheckOutrepo extends JpaRepository<CheckOutPrice, Integer> {

}
