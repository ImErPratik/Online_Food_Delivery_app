package com.myself.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myself.Model.Restaurants;

@Repository
public interface ResturantsRepo extends JpaRepository<Restaurants, Integer> {

	
}
