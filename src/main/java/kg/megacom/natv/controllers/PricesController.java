package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.models.dtos.PricesDto;
import kg.megacom.natv.services.DaysService;
import kg.megacom.natv.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/prices")
@Api(tags = Swagger.Prices)
public class PricesController {
    @Autowired
    private PriceService service;

    @PostMapping("/save")
    @ApiOperation("Сохранить цену")
    public ResponseEntity<?> save(@RequestBody PricesDto dto){
            return ResponseEntity.ok(service.save(dto));
    }


    @GetMapping("/get/{id}")
    @ApiOperation("Поиск цены по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){
            return ResponseEntity.ok(service.findById(id,lang));

    }
    @GetMapping("get/all")
    @ApiOperation("Вывести все цены")
    public ResponseEntity<?> findAll(){
            return ResponseEntity.ok(service.findAll());
    }
}
