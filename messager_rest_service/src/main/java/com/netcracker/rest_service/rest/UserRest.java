package com.netcracker.rest_service.rest;

import com.netcracker.rest_service.entity.User;
import com.netcracker.rest_service.registrator.UserRegistrator;
import com.netcracker.rest_service.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/user")
public class UserRest {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserRegistrator userRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        logger.info("Get all users");
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") long id){
        logger.info("Get user by id: "+id);
        return userRepository.getById(id);
    }
}
