package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.services.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/days")
@Api(tags = Swagger.Days)
public class DaysController {
    @Autowired
    private DaysService service;

    @PostMapping("/save")
    @ApiOperation("Сохранить день")
    public ResponseEntity<?> save(@RequestBody DaysDto dto){
        try {
            return ResponseEntity.ok(service.save(dto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }


    @GetMapping("/get/{id}")
    @ApiOperation("Поиск дня по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){
            return ResponseEntity.ok(service.findById(id,lang));

    }
    @GetMapping("get/all")
    @ApiOperation("Вывести все дни")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(service.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
