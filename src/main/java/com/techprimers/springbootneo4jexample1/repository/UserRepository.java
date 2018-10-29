package com.techprimers.springbootneo4jexample1.repository;

import com.techprimers.springbootneo4jexample1.POJO.QueryVariables;
import com.techprimers.springbootneo4jexample1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (n) RETURN n")
    List<User> getAllUsers();
    @Query("MATCH (s) WHERE ID(s)={id} RETURN s")
    User getByid(@Param("id") long id);
    @Query("MATCH (user:User) RETURN user.email")
    List<String>getAllUserEmails();
    @Query("MATCH (n) detach delete n")
     List<User> deleteAllUsers();

}
