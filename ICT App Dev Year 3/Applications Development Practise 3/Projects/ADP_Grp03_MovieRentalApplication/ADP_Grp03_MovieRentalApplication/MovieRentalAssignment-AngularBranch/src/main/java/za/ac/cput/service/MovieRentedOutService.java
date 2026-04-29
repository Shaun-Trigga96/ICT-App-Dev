//package za.ac.cput.service;
//
//import za.ac.cput.entity.MovieRentedOut;
//import za.ac.cput.repository.MovieRentedOutRepository;
//
//import java.util.Set;
//
///**
// * Author: Lance Kruger
// * Student Number: 218159501
// *lk
// */
//@Deprecated
//public class MovieRentedOutService implements IMovieRentedOutService{
//    private static MovieRentedOutService service = null;
//    private MovieRentedOutRepository repo = null;
//
//    private MovieRentedOutService(){this.repo = MovieRentedOutRepository.getRepository(); }
//
//    public static MovieRentedOutService getService(){
//        if(service == null){
//            service =new MovieRentedOutService();
//        }
//
//        return service;
//    }
//
//    @Override
//    public MovieRentedOut create(MovieRentedOut movieRentedOut) {
//        return this.repo.create(movieRentedOut);
//    }
//
//    @Override
//    public MovieRentedOut read(String movieID) {
//        return this.repo.read(movieID);
//    }
//
//    @Override
//    public MovieRentedOut update(MovieRentedOut movieRentedOut) {
//        return this.repo.update(movieRentedOut);
//    }
//
//    @Override
//    public boolean delete(String userID) {
//
//        return this.repo.delete(userID);
//    }
//
//    public Set<MovieRentedOut> getMovieName()
//    {
//        Set<MovieRentedOut> movieName =null;
//        Set<MovieRentedOut> Name = getAll();
//
//        for (MovieRentedOut movieRentedOut : Name)
//        {
//            if(MovieRentedOut.getMovieID().trim().toUpperCase().contains("A")){
//                movieName.add(movieRentedOut);
//            }
//        }
//        return movieName;
//    }
//
//    @Override
//    public Set<MovieRentedOut> getAll() {
//        return this.repo.getAll();
//    }
//}
