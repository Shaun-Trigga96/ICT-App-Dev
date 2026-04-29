package com.caniksea.secrest.service;

/**
 * Created by caniksea on 8/14/17.
 */
public interface BaseService<E, ID> {
    E save(E entity);
    E findById(ID id);
    E update(ID id);
}
