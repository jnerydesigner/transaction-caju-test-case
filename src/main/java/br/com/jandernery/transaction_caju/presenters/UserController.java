package br.com.jandernery.transaction_caju.presenters;

import br.com.jandernery.transaction_caju.application.dto.UserDTO;
import br.com.jandernery.transaction_caju.application.services.UserService;
import br.com.jandernery.transaction_caju.domain.entities.UserEntity;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserDTO user){
        UserEntity userEntity = userService.saveUser(user);

        return ResponseEntity.ok(userEntity);
    }

}
