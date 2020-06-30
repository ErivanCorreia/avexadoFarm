package br.com.avexadoFarm.infrastructure.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Autowired
    private ModelMapper modelMapper;

    public <T> T converter(Object origem, Class<T> destino) {
        return modelMapper.map(origem, destino);
    }

    public <T> Page<T> converter(Page<?> origem, Class<T> destino) {
        return origem.map(o -> modelMapper.map(o, destino));
    }
}
