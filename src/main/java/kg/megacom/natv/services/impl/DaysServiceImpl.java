package kg.megacom.natv.services.impl;

import kg.megacom.natv.mappers.DaysMapper;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.repositories.DaysRepository;
import kg.megacom.natv.services.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaysServiceImpl implements DaysService {
    @Autowired
    DaysRepository repository;
    DaysMapper mapper = DaysMapper.INSTANCE;
    @Override
    public DaysDto save(DaysDto daysDto) {
        return mapper.toDto(repository.save(mapper.toEntity(daysDto)));
    }

    @Override
    public DaysDto findById(Long id, int lang) {

        return DaysMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("sadfsd")));
    }

    @Override
    public List<DaysDto> findAll() {
        return DaysMapper.INSTANCE.toDtos(repository.findAll());
    }




}
