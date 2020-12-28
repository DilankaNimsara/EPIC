package lk.epic.controller;

import lk.epic.dto.OrderDTO;
import lk.epic.service.OrderService;
import lk.epic.util.staranded.StdRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveOrder(@RequestBody OrderDTO dto) {
        orderService.saveOrder(dto);
        return new ResponseEntity(new StdRespons(200, "Success", null), HttpStatus.OK);
    }
}
