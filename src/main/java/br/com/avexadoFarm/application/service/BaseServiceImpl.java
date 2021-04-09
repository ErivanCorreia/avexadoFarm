package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.domain.service.BaseService;
import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.repository.BaseRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Override
    public Page<T> findAll(Pageable pageable) {
       return getRepository().findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        Optional<T> entidade = getRepository().findById(id);

        if(!entidade.isPresent()) {
            throw new ObjectNotFoundException();
        }
        return entidade.get();
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        T entidade = findById(id);
        BeanUtils.copyProperties(entity, entidade, "id");
        return getRepository().save(entidade);
    }

    @Override
    public void delete(ID id) {
        T entidade = findById(id);
        getRepository().delete(entidade);
    }

    protected abstract BaseRepository<T, ID> getRepository();
}
