package by.itacademy.javaenterprise.seledtsova.dao.impl;

import by.itacademy.javaenterprise.seledtsova.dao.StatusDao;
import by.itacademy.javaenterprise.seledtsova.entity.Status;
import by.itacademy.javaenterprise.seledtsova.entity.StatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class StatusDaoImpl implements StatusDao {

    private static final Logger logger = LoggerFactory.getLogger(StatusDaoImpl.class);
    private static final String FIND_STATUS_BY_NAME_QUERY = "from Status as s where s.name=:name";
    private EntityManager entityManager;

    public StatusDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Status findStatusByName(StatusType statusType) {
        try {
            Query query = entityManager.createQuery(FIND_STATUS_BY_NAME_QUERY);
            query.setParameter("name", statusType);
            return (Status) query.getSingleResult();
        } catch (NoResultException e) {
            logger.error("cannot find status by name" + e.getMessage(), e);
        }
        return null;
    }
}

