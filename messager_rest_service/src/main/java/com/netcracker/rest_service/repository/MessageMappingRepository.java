package com.netcracker.rest_service.repository;

import com.netcracker.rest_service.entity.MessageMapping;
import com.netcracker.rest_service.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped

public class MessageMappingRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public List<MessageMapping> getAll(){ //all mes list
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteriaQuery = criteriaBuilder.createQuery(MessageMapping.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public MessageMapping getById(long id){
        logger.info("Get message mapping bu Id: "+id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromUser(User from_id){ //по отправителю
        logger.info("Get message mapping by user from_id: "+ from_id);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteriaQuery = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteriaQuery.from(MessageMapping.class);
        criteriaQuery.select(element).where(criteriaBuilder.equal(element.get("from_id"), from_id));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
