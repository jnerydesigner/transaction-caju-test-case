package br.com.jandernery.transaction_caju.application.services;

import br.com.jandernery.transaction_caju.application.dto.UserDTO;
import br.com.jandernery.transaction_caju.domain.mappers.UserMapper;
import br.com.jandernery.transaction_caju.domain.mappers.UserResponseMapper;
import br.com.jandernery.transaction_caju.domain.mappers.projection.UserResponseProjection;
import br.com.jandernery.transaction_caju.domain.model.UserModel;
import br.com.jandernery.transaction_caju.infra.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public UserResponseMapper findById(Long userId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

      ModelMapper modelMapper = new ModelMapper();
      UserMapper user = modelMapper.map(userModel, UserMapper.class);


        List<UserResponseProjection> userProjections = userRepository.findByUserIdComplete(userId);


        if(userProjections.isEmpty()){
            return null;
        }

        UserResponseMapper.UserMapper userMapper = new UserResponseMapper.UserMapper();
        UserResponseMapper.AccountMapper accountMapper = new UserResponseMapper.AccountMapper();
        List<UserResponseMapper.TypeMapper> types = new ArrayList<>();

        UserResponseProjection projection = userProjections.get(0);

        userMapper.setId(projection.getUserId());
        userMapper.setName(projection.getName());
        userMapper.setUsername(projection.getUserName());

        accountMapper.setId(projection.getAccountId());
        accountMapper.setBalanceAmount(projection.getAmount());

        for (UserResponseProjection proj : userProjections){
            UserResponseMapper.TypeMapper typeMapper = new UserResponseMapper.TypeMapper();
            typeMapper.setId(proj.getAccountTypeId());
            typeMapper.setBalanceType(proj.getTypeBalance());
            typeMapper.setBalance(proj.getAmountType());
            types.add(typeMapper);
        }

        accountMapper.setType(types);

        userMapper.setAccount(accountMapper);

        UserResponseMapper userResponseMapper = new UserResponseMapper();

        userResponseMapper.setUser(userMapper);








        return userResponseMapper;
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
