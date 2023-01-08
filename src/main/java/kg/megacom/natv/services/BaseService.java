package kg.megacom.natv.services;

import kg.megacom.natv.exceptions.SaveTroubleException;

import java.util.List;

public interface BaseService<T> {
    T save(T t) throws SaveTroubleException;
    T findById(Long id, int lang);
    List<T> findAll();

}
