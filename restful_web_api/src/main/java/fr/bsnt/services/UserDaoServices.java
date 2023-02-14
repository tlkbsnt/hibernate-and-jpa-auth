package fr.bsnt.services;

import fr.bsnt.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDaoServices {
    private static List<User> users = new ArrayList<>();
    private static int userCount=0;
    static{
        users.add( new User(++userCount,"Tilak", LocalDate.now().now().minusYears(32)) );
        users.add( new User(++userCount,"Atikshaya", LocalDate.now().now().minusYears(2)) );
        users.add( new User(++userCount,"Devil", LocalDate.now().now().minusYears(4)) );
        users.add( new User(++userCount,"Suzan", LocalDate.now().now().minusYears(324)) );
    }
    public  List<User> findAll() {
        return users;
    }
    public User saveUser(User user){
        user.setId( ++userCount );
        users.add( user );
        return user;
    }
    public User findOne(int id){
        Predicate<? super User> predicate = user -> Objects.equals( user.getId(), id );
        return users.stream().filter( predicate ).findFirst().get();
    }
    public void deleteById(int id){
        Predicate<? super User> predicate = user -> Objects.equals( user.getId(), id );
        users.removeIf( predicate );
        //  return users.stream().filter( predicate ).findFirst().get();
    }

}
