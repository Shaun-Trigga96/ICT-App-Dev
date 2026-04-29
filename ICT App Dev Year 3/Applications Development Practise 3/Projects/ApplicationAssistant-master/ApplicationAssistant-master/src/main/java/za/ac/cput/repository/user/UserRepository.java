package za.ac.cput.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.User;
import za.ac.cput.repository.IRepository;

import java.util.Set;


@Repository
public interface UserRepository extends JpaRepository<User, String >{

}
