package by.itacademy.javaenterprise.seledtsova.dao.impl;

import by.itacademy.javaenterprise.seledtsova.dao.RoleDao;
import by.itacademy.javaenterprise.seledtsova.entity.Role;
import by.itacademy.javaenterprise.seledtsova.entity.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RoleDaoImpl implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
    private static final String FIND_ROLE_BY_NAME_QUERY = "from Role as r where r.name=:name";

    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleById(Long id) {
        Role role = new Role();
        try {
            role = entityManager.find(Role.class, id);
        } catch (Exception e) {
            logger.error("Cannot find role by id" + e.getMessage(), e);
        }
        return role;
    }

    @Override
    public Role findRoleByName(RoleType roleType) {
        try {
            Query query = entityManager.createQuery(FIND_ROLE_BY_NAME_QUERY);
            query.setParameter("name", roleType);
            return (Role) query.getSingleResult();
        } catch (Exception e) {
            logger.error("Cannot find role by id" + e.getMessage(), e);
        }
        return null;
    }
}
