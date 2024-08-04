package com.example.Glovo.JP_H20_Glovo.repository;

import com.example.Glovo.JP_H20_Glovo.models.OrderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public OrderEntity findById(Long id) {
        return entityManager.find(OrderEntity.class, id);
    }

    public void save(OrderEntity order) {
        entityManager.persist(order);
    }

    public void update(OrderEntity order) {
        entityManager.merge(order);
    }

    public void delete(OrderEntity order) {
        entityManager.remove(order);
    }

}
