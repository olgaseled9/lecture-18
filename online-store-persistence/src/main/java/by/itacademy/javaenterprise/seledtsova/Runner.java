package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.dao.*;
import by.itacademy.javaenterprise.seledtsova.dao.impl.*;
import by.itacademy.javaenterprise.seledtsova.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.it");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        RoleDao roleDao = new RoleDaoImpl(entityManager);
        Role role = roleDao.findRoleById(1L);
        Role role1 = roleDao.findRoleByName(RoleType.ROLE_ADMINISTRATOR);
        UserDao userDao = new UserDaoImpl(entityManager);
        User user = userDao.findUserById(3L);
        StatusDao statusDao = new StatusDaoImpl(entityManager);
        Status status = statusDao.findStatusByName(StatusType.NEW);
        OrderDao orderDao = new OrderDaoImpl(entityManager);
        Order order = orderDao.findOrderById(1L);
        logger.info("{}", user);
        logger.info("{}", role);
        logger.info("{}", role1);
        logger.info("{}", status);
        logger.info("{}", order);
        logger.info("{}", userDao.findAll());
        logger.info("{}", orderDao.findAll());
        ItemDao itemDao = new ItemDaoImpl(entityManager);
        Item item = itemDao.findItemById(1L);
        logger.info("{}", item);
        logger.info("{}", itemDao.findAll());
        Order order1=orderDao.findOrderByUsername("bird");
        logger.info("{}", order1);
        entityManager.close();
    }
}
