package lk.epic.service.impl;

import lk.epic.dto.OrderDTO;
import lk.epic.entity.Orders;
import lk.epic.repo.OrderRepo;
import lk.epic.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveOrder(OrderDTO dto) {
        repo.save(mapper.map(dto, Orders.class));
    }
}
