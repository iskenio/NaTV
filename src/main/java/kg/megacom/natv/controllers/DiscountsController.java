package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.models.dtos.DiscountsDto;
import kg.megacom.natv.services.DaysService;
import kg.megacom.natv.services.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/discounts")
@Api(tags = Swagger.Discounts)
public class DiscountsController {
    @Autowired
    private DiscountsService service;

    @PostMapping("/save")
    @ApiOperation("Сохранить скидку")
    public DiscountsDto save(@RequestBody DiscountsDto dto){
            return service.save(dto);
    }


    @GetMapping("/get/{id}")
    @ApiOperation("Поиск скидки по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){
            return ResponseEntity.ok(service.findById(id,lang));
    }
    @GetMapping("get/all")
    @ApiOperation("Вывести все скидки")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(service.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
