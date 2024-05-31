package com.bootcamp.sp.democalculatorsb.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sp.democalculatorsb.controller.CustomerOperation;
import com.bootcamp.sp.democalculatorsb.model.Customer;
import com.bootcamp.sp.democalculatorsb.model.Order;


@Controller
@ResponseBody
public class CustomerController implements CustomerOperation {

    @Override
    public List<Customer> getAll() {
        return new ArrayList<Customer>(List.of(
                new Customer("Vincent", LocalDate.of(2013, 10, 1),
                        new ArrayList<Order>(List.of(
                                new Order(1,
                                        List.of("12 ROAD", "Wan Chai",
                                                "Hong Kong")),
                                new Order(2,
                                        List.of("Big Road", "Tsing Yi",
                                                "NT"))))),
                new Customer("Jenny", LocalDate.of(2013, 10, 1),
                        new ArrayList<Order>(List.of(
                                new Order(3,
                                        List.of("Asakusa", "Tokyo", "Japan")),
                                new Order(4, List.of("five Smell Street",
                                        "Diamond Hill", "Kowloon")))))));

    }

}
