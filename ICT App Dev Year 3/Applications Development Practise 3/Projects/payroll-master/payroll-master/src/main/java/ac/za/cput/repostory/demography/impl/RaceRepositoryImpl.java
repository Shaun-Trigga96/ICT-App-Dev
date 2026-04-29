//package ac.za.cput.repostory.demography.impl;
//
//import ac.za.cput.domain.demography.Race;
//import ac.za.cput.repostory.demography.RaceRepository;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public abstract class RaceRepositoryImpl implements RaceRepository {
//
//    @Override
//    public Race retrieveByDesc(String raceDesc) {
//        return findAll().stream().filter(race -> race.getDesc().equalsIgnoreCase(raceDesc)).findAny().orElse(null);
//    }
//}
