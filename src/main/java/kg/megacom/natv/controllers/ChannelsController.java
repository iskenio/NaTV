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

    @PostMapping("/save/channel")
    @ApiOperation("Сохранить канал")
    public ResponseEntity<?> saveChannel(@RequestParam String name, @RequestParam MultipartFile photo, @RequestParam int orderNum, int lang){
            return ResponseEntity.ok(service.saveChannel(name, photo, orderNum, lang));

    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск канала по id")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader int lang){

            return ResponseEntity.ok(service.findById(id,lang));

    }

    @GetMapping("get/allResponse")
    @ApiOperation("Вывести все каналы")
    public ResponseEntity<?> findAllResponse(int page, int size){
            return ResponseEntity.ok(service.channelRes(page, size));

    }
}
