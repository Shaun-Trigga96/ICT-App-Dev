/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * IService.java
 */

package za.ac.cput.service;

public interface IService <T, t>{
    T save(T t);
    T find(t t);
    T update(T t);
    boolean delete(T t);
}
