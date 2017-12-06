package com.netcracker.rest_service.rest;

import com.netcracker.rest_service.entity.MessageMapping;
import com.netcracker.rest_service.registrator.MessageMappingRegistrator;
import com.netcracker.rest_service.repository.MessageMappingRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/message_mapping")
public class MessageMappingRest {
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/") //all data
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
        logger.info("Get full message mapping");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(long id){
        logger.info("Get message mapping bu id: "+id);
        return  repository.getById(id);
    }
}
