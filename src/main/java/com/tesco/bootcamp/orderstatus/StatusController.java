package com.tesco.bootcamp.orderstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx11 on 11/01/2017.
 */
@RestController
@EnableAutoConfiguration
public class StatusController {

    private final OrderService orderService;

    @Autowired
    public StatusController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order-status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OrderStatus getOrderStatus(@RequestParam(value = "orderId") String orderId) {
        return orderService.getOrderStatus(orderId).orElseThrow(OrderStatusNotFound::new);
    }
}
