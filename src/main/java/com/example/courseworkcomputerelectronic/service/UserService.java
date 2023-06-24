package com.example.courseworkcomputerelectronic.service;

import com.example.courseworkcomputerelectronic.IUserService;
import com.example.courseworkcomputerelectronic.UserRegistrationDto;
import com.example.courseworkcomputerelectronic.entity.Product;
import com.example.courseworkcomputerelectronic.entity.Role;
import com.example.courseworkcomputerelectronic.entity.User;
import com.example.courseworkcomputerelectronic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan(basePackages = {"com.example.courseworkcomputerelectronic.service"})
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Boolean passwordMatch(String password, User user){
        return passwordEncoder.matches(password, user.getPassword());
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(UserRegistrationDto rDto) {
        User user = new User(rDto.getFirstName(), rDto.getLastName(),
                rDto.getEmail(), passwordEncoder.encode(rDto.getPassword()), Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return mapRoles;
    }

    public String passwordEncode(String newP) {
        return passwordEncoder.encode(newP);
    }
}
