package za.ac.cput.service;

import za.ac.cput.entity.Rating;

import java.util.Set;

public interface IRatingService extends IService<Rating,String>{
    Set<Rating> getAll();
}
