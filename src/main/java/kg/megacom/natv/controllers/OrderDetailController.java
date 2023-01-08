package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.models.dtos.OrderDetailDto;
import kg.megacom.natv.services.DaysService;
import kg.megacom.natv.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order/detail")
@Api(tags = Swagger.OrderDetail)
public class OrderDetailController {
    @Autowired
    private OrderDetailService service;

    @PostMapping("/save")
    @ApiOperation("Сохранить детали заявки")
    public ResponseEntity<?> save(@RequestBody OrderDetailDto dto){

            return ResponseEntity.ok(service.save(dto));

    }


    @GetMapping("/get/{id}")
    @ApiOperation("Поиск детали заявки по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){
        try {
            return ResponseEntity.ok(service.findById(id,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("get/all")
    @ApiOperation("Вывести все деталей заявки")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(service.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
