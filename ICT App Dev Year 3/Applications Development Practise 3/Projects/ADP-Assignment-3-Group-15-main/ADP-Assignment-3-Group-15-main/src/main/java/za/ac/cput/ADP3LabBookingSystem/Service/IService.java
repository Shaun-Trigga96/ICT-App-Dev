/*
 * IService.java
 * IService interface class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Service;

public interface IService<T, ID> {
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
