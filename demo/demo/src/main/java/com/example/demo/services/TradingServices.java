package com.example.demo.services;


import com.example.demo.Entity.*;
import com.example.demo.Repo.OrderRepo;
import com.example.demo.Repo.StockRepository;
import com.example.demo.Repo.userRepo;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class TradingServices {

    @Autowired
    private userRepo userRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private OrderRepo orderRepository;


    public void buyStock(TradeRequest request) {

        users user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Stock stock = stockRepository.findById(request.getStockId())
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        double totalPrice = stock.getPrice() * request.getQuantity();

        if (user.getCoins() < totalPrice) {
            throw new RuntimeException("Insufficient fund");
        }


        user.setCoins(user.getCoins() - totalPrice);
        userRepository.save(user);

        order order = new order();
        order.setUser(user);
        order.setStock(stock);
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(totalPrice);

        orderRepository.save(order);
    }

    //sell
    public void sellStock(TradeRequest request) {

        users user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Stock stock = stockRepository.findById(request.getStockId())
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        double totalPrice = stock.getPrice() * request.getQuantity();

       // save coin
        user.setCoins(user.getCoins() + totalPrice);
        userRepository.save(user);

       order order = new order();
        order.setUser(user);
        order.setStock(stock);
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(totalPrice);
        order.setType(OrderType.SELL);


        orderRepository.save(order);
    }
}
