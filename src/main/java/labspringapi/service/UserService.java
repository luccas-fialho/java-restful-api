package labspringapi.service;

import org.springframework.stereotype.Service;

import labspringapi.domain.model.User;

@Service
public interface UserService {
  
  public User getUserById(Long id);

  public User createUser(User user);
}
