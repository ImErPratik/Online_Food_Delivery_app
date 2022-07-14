package com.myself.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myself.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
