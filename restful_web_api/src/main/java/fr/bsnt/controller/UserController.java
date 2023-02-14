package fr.bsnt.controller;

import fr.bsnt.model.User;
import fr.bsnt.services.UserDaoServices;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
@RestController
public class UserController {
    private UserDaoServices services;
    public UserController(UserDaoServices services) {
        this.services = services;
    }
    @GetMapping("/users")
    public List<User> retrieveAll(){
        return services.findAll();
    }
    @SneakyThrows
    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id)  {
        User user = services.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id: " +id);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        services.deleteById( id );
    }
    @PostMapping("/users")
    public ResponseEntity<User> create(@Validated @RequestBody User user){
        User savedUser = services.saveUser( user );
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( savedUser.getId() )
                .toUri();
        return ResponseEntity.created( location  ).build();
    }
}
