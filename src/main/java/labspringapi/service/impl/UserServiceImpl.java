package labspringapi.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import labspringapi.domain.model.User;
import labspringapi.domain.repository.UserRepository;
import labspringapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public User createUser(User user) {
    if(userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
      throw new IllegalArgumentException("This user account number already exists.");
    }
    return userRepository.save(user); 
  }
  
}
