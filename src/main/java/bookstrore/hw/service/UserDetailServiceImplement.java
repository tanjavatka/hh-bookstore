package bookstrore.hw.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookstrore.hw.domain.AppUser;
import bookstrore.hw.domain.AppUserRepository;

@Service
public class UserDetailServiceImplement implements UserDetailsService {

  private final AppUserRepository appRepository;

  public UserDetailServiceImplement(AppUserRepository userRepository) {
    this.appRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser currentUser = appRepository.findByUsername(username);
    UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
        AuthorityUtils.createAuthorityList(currentUser.getRole()));

    return user;
  }
}
