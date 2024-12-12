package com.revature.repository;

import com.revature.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * JPA Repository takes two generics
 *  * The type of entity we are working with
 *  * The type of primary key of that Entity
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
