package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.application.dto.UserDTO;
import br.com.jandernery.transaction_caju.domain.entities.UserEntity;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserDTO userDto){
        UserModel user = new UserModel();
            user.setUserName(userDto.userName());
            user.setName(userDto.name());

        UserModel userSave = userRepository.save(user);


        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userSave, UserEntity.class);

        return userEntity;
    }
}
