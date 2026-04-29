/*
 * IRepository.java
 * Repository Interface.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 26 July 2021
 * */package za.ac.cput.ADP3LabBookingSystem.Repository;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import java.util.Set;

@Deprecated
public interface IRepository<T, ID> {
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
    public Set<T> getAll();
}
