package ac.za.cput.service.demography;

import ac.za.cput.domain.demography.Race;
import ac.za.cput.service.IService;

import java.util.List;

public interface RaceService extends IService<Race, String> {
    Race retrieveByDesc(String raceDesc);
    List<Race> getAll();
}
