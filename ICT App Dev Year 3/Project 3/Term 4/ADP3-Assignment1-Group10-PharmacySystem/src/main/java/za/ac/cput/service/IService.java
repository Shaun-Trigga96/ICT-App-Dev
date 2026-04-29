package za.ac.cput.service;

public interface IService<T, ID>{

    public T save(T t);

    public T read(ID id);

    public boolean delete(ID id);
}
