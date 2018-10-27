package com.techprimers.springbootneo4jexample1.repository;

import com.techprimers.springbootneo4jexample1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (n) RETURN n")
    List<User> getAllUsers();

}
