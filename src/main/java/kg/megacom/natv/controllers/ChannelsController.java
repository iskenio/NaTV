package kg.megacom.natv.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.natv.configs.Swagger;
import kg.megacom.natv.models.dtos.ChannelsDto;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.services.ChannelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/channel")
@Api(tags = Swagger.Channels)
public class ChannelsController {
    @Autowired
    private ChannelsService service;

//    @PostMapping("/save")
//    @ApiOperation("Сохранить канал")
//    public ResponseEntity<?> save(@ModelAttribute ChannelsDto dto){
//        try {
//            return ResponseEntity.ok(service.save(dto));
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
//        }
//    }

    @PostMapping("/save/channel")
    @ApiOperation("Сохранить канал")
    public ResponseEntity<?> saveChannel(@RequestParam String name, @RequestParam MultipartFile photo, @RequestParam int orderNum){

            return ResponseEntity.ok(service.saveChannel(name, photo, orderNum));

    }



    @GetMapping("/get/{id}")
    @ApiOperation("Поиск канала по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){

            return ResponseEntity.ok(service.findById(id,lang));

    }
//    @GetMapping("get/all")
//    @ApiOperation("Вывести все каналы")
//    public ResponseEntity<?> findAll(){
//        try {
//            return ResponseEntity.ok(service.findAll());
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//    }

    @GetMapping("get/allResponse")
    @ApiOperation("Вывести все каналы")
    public ResponseEntity<?> findAllResponse(){

            return ResponseEntity.ok(service.channelRes());

    }
}
