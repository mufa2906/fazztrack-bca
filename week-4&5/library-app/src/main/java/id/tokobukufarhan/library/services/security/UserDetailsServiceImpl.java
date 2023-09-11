package id.tokobukufarhan.library.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.User;
import id.tokobukufarhan.library.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    /*
     * findByEmail
     * if true, build userdetails untuk security context holder
     * if false, user not found
     */
    if(!userRepository.existsByEmail(username)){
      throw new UnsupportedOperationException(username + " is not found");
    }

    User user = userRepository.findByEmail(username);

     // validasi dari obj user atau creator atau admin mana yg ngga null
    // yg ngga null adalah admin -> role = "ROLE_ADMIN"

    return UserDetailsImpl.build(user);
  }
  
}
