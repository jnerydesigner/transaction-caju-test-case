package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.application.dto.UserDTO;
import br.com.jandernery.transaction_caju.domain.mappers.UserMapper;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserMapper saveUser(UserDTO userDto){
        UserModel userFindByName = userRepository.findByUserName(userDto.userName());
        if(userFindByName == null){
            UserModel user = new UserModel();
            user.setUserName(userDto.userName());
            user.setName(userDto.name());

            UserModel userSave = userRepository.save(user);
            ModelMapper modelMapper = new ModelMapper();
            UserMapper userEntity = modelMapper.map(userSave, UserMapper.class);

            return userEntity;
        }

        ModelMapper modelMapper = new ModelMapper();
        UserMapper userEntity = modelMapper.map(userFindByName, UserMapper.class);



        return userEntity;
    }

    public UserMapper findById(Long userId, Long accountId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

      ModelMapper modelMapper = new ModelMapper();
      UserMapper user = modelMapper.map(userModel, UserMapper.class);


        return user;
    }

    private Boolean findByUserName(String userName){
        System.out.println(userName);
        UserModel user = userRepository.findByUserName(userName);
        System.out.println(user.getUserName());
        if(user != null || user.getUserName() != ""){
            throw new IllegalArgumentException("User if exists");
        }

        return false;
    }


}
