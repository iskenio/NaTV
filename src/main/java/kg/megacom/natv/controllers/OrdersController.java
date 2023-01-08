package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.OrdersDto;
import kg.megacom.natv.models.requests.ChannelReq;
import kg.megacom.natv.models.requests.OrderReq;
import kg.megacom.natv.models.responces.OrderResponse;
import kg.megacom.natv.services.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@Api(tags = Swagger.Orders)
public class OrdersController {
    @Autowired
    private OrdersService service;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    @ApiOperation("Сохранить заявку")
    public ResponseEntity<?> save(@RequestBody OrdersDto dto){
        try {
            return ResponseEntity.ok(service.save(dto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }


    @GetMapping("/get/{id}")
    @ApiOperation("Поиск заявки по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){
            return ResponseEntity.ok(service.findById(id,lang));
    }
    @GetMapping("get/all")
    @ApiOperation("Вывести все заявки")
    public ResponseEntity<?> findAll(){
            return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("set/order")
    @ApiOperation("заполнить заявку")
    public ResponseEntity<?>saveOrder(OrderReq orderRequest, int lang) {
            return ResponseEntity.ok(service.saveOrder(orderRequest, lang));
    }

    @GetMapping("get/order")
    @ApiOperation("Вывести заявку")
    public ResponseEntity<?>getOrder(@RequestBody OrderReq orderReq, int lang){

            return ResponseEntity.ok(service.getOrder(orderReq, lang));
    }
}
