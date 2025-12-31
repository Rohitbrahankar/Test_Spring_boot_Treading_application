//package com.example.demo.services;
//
//
//import com.example.demo.Entity.OrderType;
//import com.example.demo.Entity.Stock;
//import com.example.demo.Entity.order;
//import com.example.demo.Entity.users;
//import com.example.demo.Repo.userRepo;
//import jakarta.persistence.criteria.Order;
//
//
//public void sellStock(Long userId, Stock stock, int quantity) {
//    users user = userRepo.findById(userId)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//
//
//    double totalPrice = stock.getPrice() * quantity;
//
//    // Add coins
//    user.setCoins(user.getCoins() + totalPrice);
//    userRepo.save(user);
//
//    order order = new order();
//    order.setUser(user);
//    order.setStock(stock);
//    order.setQuantity(quantity);
//    order.setTotalPrice(totalPrice);
//
//
//    orderRepo.save(order);
//}
//}
