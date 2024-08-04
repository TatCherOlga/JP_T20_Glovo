package com.example.Glovo.JP_H20_Glovo.controllers;

import com.example.Glovo.JP_H20_Glovo.models.OrderEntity;
import com.example.Glovo.JP_H20_Glovo.models.ProductEntity;
import com.example.Glovo.JP_H20_Glovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("{orderId}")
    @ResponseBody
    public OrderEntity getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    @ResponseBody
    public void createOrder(@RequestBody OrderEntity order) {
        orderService.createOrder(order);
    }

    @PutMapping("{orderId}")
    @ResponseBody
    public void updateOrder(@PathVariable Integer orderId, @RequestBody OrderEntity order) {
        order.setId(orderId);
        orderService.updateOrder(order);
    }

    @PatchMapping("{orderId}/products")
    @ResponseBody
    public void addProductToOrder(@PathVariable Long orderId, @RequestBody ProductEntity product) {
        orderService.addProductToOrder(orderId, product);
    }

    @DeleteMapping("{orderId}/products/{productId}")
    @ResponseBody
    public void removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.removeProductFromOrder(orderId, productId);

    }

    @DeleteMapping("{orderId}")
    @ResponseBody
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
