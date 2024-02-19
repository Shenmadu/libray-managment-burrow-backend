package edu.icet.service.impl;
import edu.icet.dto.BurrowDto;
import edu.icet.entity.Burrower;
import edu.icet.repository.BurrowerRepository;
import edu.icet.service.BurrowService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BurrowServiceImpl implements BurrowService {

    final BurrowerRepository repository;

    ModelMapper mapper;

    @Bean
    public void run(){
        this.mapper=new ModelMapper();
    }

    @Override
    public void addBurrower(BurrowDto burrowDto) {
        Burrower entity = mapper.map(burrowDto, Burrower.class);
        repository.save(entity);

    }

    @Override
    public List<Burrower> getBurrowers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteBurrower(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
