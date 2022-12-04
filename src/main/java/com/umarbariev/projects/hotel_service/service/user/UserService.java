package com.umarbariev.projects.hotel_service.service.user;

import com.umarbariev.projects.hotel_service.dto.user.UserDto;
import com.umarbariev.projects.hotel_service.entities.User;
import com.umarbariev.projects.hotel_service.repositories.UserRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("No such user!");
        }
        return user;
    }

    public boolean saveUser(UserDto userDto) {
        var userFromDb = userRepository.findUserByUsername(userDto.getUsername()).orElse(null);

        if (userFromDb != null) {
            return false;
        }
        var user = BasicConverter.convert(userDto, User.class);
        user.setEnabled(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
