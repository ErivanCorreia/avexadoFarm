package br.com.avexadoFarm.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

    public Page<T> findAll(Pageable pageable);

    public T findOne(ID id);

    public T save(T entity);

    public T update(ID id, T entity);

    public void delete(ID id);
}
