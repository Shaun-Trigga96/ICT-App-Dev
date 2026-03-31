//package za.ac.cput.repository.user.impl;
//
//import za.ac.cput.entity.user.User;
//import za.ac.cput.repository.user.UserRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class UserRepositoryImpl implements UserRepository {
//    private static UserRepository repository = null;
//    private Set<User> userSet;
//
//    private UserRepositoryImpl() { this.userSet = new HashSet<>(); }
//
//    public static UserRepository getRepository()
//    {
//        if(repository == null)
//        {
//            repository = new UserRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<User> getAll() { return this.userSet; }
//
//    @Override
//    public User create(User user)
//    {
//        this.userSet.add(user);
//        return user;
//    }
//
//    @Override
//    public User read(String userId)
//    {
//        for(User user : this.userSet)
//        {
//            if(user.getUserId().equalsIgnoreCase(userId))
//            {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public User update(User user)
//    {
//        boolean deleteUser = delete(user.getUserId());
//        if(deleteUser)
//        {
//            this.userSet.add(user);
//            return user;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String userId)
//    {
//        User user = read(userId);
//        if(user != null)
//        {
//            this.userSet.remove(user);
//            return true;
//        }
//        return false;
//    }
//
//}
