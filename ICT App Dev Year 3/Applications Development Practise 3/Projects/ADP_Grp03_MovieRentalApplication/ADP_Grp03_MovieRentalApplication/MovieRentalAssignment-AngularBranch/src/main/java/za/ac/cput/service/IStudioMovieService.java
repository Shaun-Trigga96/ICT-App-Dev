package za.ac.cput.service;

import za.ac.cput.entity.StudioMovie;

import java.util.Set;

public interface IStudioMovieService extends IService<StudioMovie, String>{
    public Set<StudioMovie>getAll();
}
