package za.ac.cput.service;
/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */
import za.ac.cput.entity.Genre;

import java.util.Set;

public interface IGenreService extends IService<Genre, String>{
    public Set<Genre>getAll();
}
