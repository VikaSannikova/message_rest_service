package com.netcracker.rest_service.rest;

import com.netcracker.rest_service.entity.Message;
import com.netcracker.rest_service.registrator.MessageRegistrator;
import com.netcracker.rest_service.repository.MessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/message")
public class MessageRest {
    @Inject
    private Logger logger;

    @Inject
    private MessageRepository messageRepository; //для запросов получения data

    @Inject
    private MessageRegistrator messageRegistrator; //для изменения сообщений data update

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getListAll(){
        logger.info("Get all messages");
        return messageRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(@PathParam("id") long id){
        return messageRepository.getById(id);
    }
}
