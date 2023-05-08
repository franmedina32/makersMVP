package com.example.makersMVP.service;

import com.example.makersMVP.domain.Collection;
import com.example.makersMVP.domain.User;
import com.example.makersMVP.dto.UserCollectionDTO;
import com.example.makersMVP.dto.UserDTO;
import com.example.makersMVP.exceptions.BadRequestException;
import com.example.makersMVP.exceptions.ResourceNotFoundException;
import com.example.makersMVP.repository.CollectionRepository;
import com.example.makersMVP.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private CollectionRepository collectionRepository;

    public UserService(UserRepository userRepository, CollectionRepository collectionRepository) {
        this.userRepository = userRepository;
        this.collectionRepository = collectionRepository;
    }

    public User DTOtoUser(UserDTO userDTO) {
        return new User(userDTO.getUserEmail(), userDTO.getPassword());
    }

    public UserDTO userToDTO(User user) {
        return new UserDTO(user.getUserEmail(), user.getPassword());
    }

    public User registerUser(UserDTO userDTO) throws BadRequestException {
        try {
            User user = DTOtoUser(userDTO);
            return userRepository.save(user);
        }
        catch (Exception e) {
             throw new BadRequestException("UNABLE TO STORE USER");
        }
    }

    public User findUserByUserEmail(UserDTO userDTO) throws ResourceNotFoundException {
        Optional<User> userSearch = userRepository.findByuserEmail(userDTO.getUserEmail());
        if (userSearch.isPresent()){
            return userSearch.get();
        }
        else {
            throw new ResourceNotFoundException("USER NOT FOUND");
        }
    }

    public boolean login(UserDTO userDTO) throws ResourceNotFoundException {
        Optional<User> userSearch = userRepository.findByuserEmail(userDTO.getUserEmail());
        if (userSearch.isPresent()){
            return true;
        }
        else {
            throw new ResourceNotFoundException("USER NOT FOUND");
        }
    }

    public User addFavCollection(UserCollectionDTO userCollectionDTO) throws BadRequestException {
            Optional<Collection> collectionSearch = collectionRepository.findByName(userCollectionDTO.getCollectionName());
            Optional<User> userSearch = userRepository.findByuserEmail(userCollectionDTO.getUserEmail());
            if (collectionSearch.isPresent() && userSearch.isPresent()){
                userSearch.get().addFav(collectionSearch.get());
                return userRepository.save(userSearch.get());
            } else if (userSearch.isPresent() && collectionSearch.isEmpty()) {
                Collection collection = collectionRepository.save(new Collection(userCollectionDTO.getCollectionName(), userCollectionDTO.getContractAddress()));
                userSearch.get().addFav(collection);
                return userRepository.save(userSearch.get());
            }
            else {
                throw new BadRequestException("UNABLE TO STORE COLLECTION AS FAV");
            }
    }

    public User unsetFav(UserCollectionDTO userCollectionDTO) throws BadRequestException {
        Optional<Collection> collectionSearch = collectionRepository.findByName(userCollectionDTO.getCollectionName());
        Optional<User> userSearch = userRepository.findByuserEmail(userCollectionDTO.getUserEmail());
        if (collectionSearch.isPresent() && userSearch.isPresent()){
            userSearch.get().deleteFav(collectionSearch.get());
            return userRepository.save(userSearch.get());
        }
        else {
            throw new BadRequestException("UNABLE TO DELETE COLLECTION FROM USER FAVS");
        }
    }


}
