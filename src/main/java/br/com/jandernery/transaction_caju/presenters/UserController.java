package br.com.jandernery.transaction_caju.presenters;

import br.com.jandernery.transaction_caju.application.dto.UserDTO;
import br.com.jandernery.transaction_caju.application.services.UserService;
import br.com.jandernery.transaction_caju.domain.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<UserMapper> saveUser(@RequestBody UserDTO user){
        UserMapper userEntity = userService.saveUser(user);
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/find-one/{userId}/{accountId}")
    public ResponseEntity<UserMapper> findById(@PathVariable("userId") Long userId, @PathVariable("accountId") Long accountId){
        return ResponseEntity.ok(userService.findById(userId, accountId));
    }

}
