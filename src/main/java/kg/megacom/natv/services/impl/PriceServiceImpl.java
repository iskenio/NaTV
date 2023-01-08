package kg.megacom.natv.services.impl;

import kg.megacom.natv.mappers.PriceMapper;
import kg.megacom.natv.models.dtos.PricesDto;
import kg.megacom.natv.repositories.PricesRepository;
import kg.megacom.natv.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PricesRepository repository;
    PriceMapper mapper = PriceMapper.INSTANCE;
    @Override
    public PricesDto save(PricesDto pricesDto) {
        return mapper.toDto(repository.save(mapper.toEntity(pricesDto)));
    }

    @Override
    public PricesDto findById(Long id, int lang) {
        return mapper.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("sfdsdffsdsdf")));
    }

    @Override
    public List<PricesDto> findAll() {
        return mapper.toDtos(repository.findAll());
    }


    @Override
    public BigDecimal getChannelPrice(Long channelId) {
        return repository.getChannelPrice(channelId);
    }
}
