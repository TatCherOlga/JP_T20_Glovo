package com.example.Glovo.JP_H20_Glovo.service;

import com.example.Glovo.JP_H20_Glovo.models.OrderEntity;
import com.example.Glovo.JP_H20_Glovo.models.ProductEntity;
import com.example.Glovo.JP_H20_Glovo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderEntity getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void createOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    public void updateOrder(OrderEntity order) {
        orderRepository.update(order);
    }

    public void deleteOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId);
        if (order != null) {
            orderRepository.delete(order);
        }
    }

    public void addProductToOrder(Long orderId, ProductEntity product) {
        OrderEntity order = orderRepository.findById(orderId);
        if (order != null) {
            order.getProducts().add(product);
            orderRepository.update(order);
        }
    }

    public void removeProductFromOrder(Long orderId, Long productId) {
        OrderEntity order = orderRepository.findById(orderId);
        if (order != null) {
            order.getProducts().removeIf(product -> product.getId().equals(productId));
            orderRepository.update(order);
        }
    }

}