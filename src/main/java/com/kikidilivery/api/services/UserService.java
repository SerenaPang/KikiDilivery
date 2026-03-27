package com.kikidilivery.api.services;

import com.kikidilivery.api.domain.User;
import com.kikidilivery.api.domain.UserRole;
import com.kikidilivery.api.dto.UserCreation;
import com.kikidilivery.api.dto.UserUpdate;
import com.kikidilivery.api.dto.UserView;
import com.kikidilivery.api.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserView> findAllWithFilters(String name, String email, String role) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> name == null
                        || (u.getName() != null && u.getName().toLowerCase().contains(name.toLowerCase())))
                .filter(u -> email == null
                        || (u.getEmail() != null && u.getEmail().toLowerCase().contains(email.toLowerCase())))
                .filter(u -> role == null || (u.getRole() != null && u.getRole().name().equalsIgnoreCase(role)))
                .map(this::toView)
                .toList();
    }

    public Optional<UserView> findById(UUID id) {
        return userRepository.findById(id).map(this::toView);
    }

    public UserView create(UserCreation dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole() != null ? UserRole.valueOf(dto.getRole().toUpperCase()) : null);
        return toView(userRepository.save(user));
    }

    public Optional<UserView> update(UUID id, UserUpdate dto) {
        return userRepository.findById(id).map(user -> {
            if (dto.getName() != null)
                user.setName(dto.getName());
            if (dto.getEmail() != null)
                user.setEmail(dto.getEmail());
            if (dto.getRole() != null)
                user.setRole(UserRole.valueOf(dto.getRole().toUpperCase()));
            return toView(userRepository.save(user));
        });
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public List<UserView> findDriversByShipment(UUID shipmentId) {
        return userRepository.findDriversByShipment(shipmentId)
                .stream()
                .map(this::toView)
                .toList();
    }

    private UserView toView(User user) {
        UserView view = new UserView();
        view.setId(user.getId());
        view.setName(user.getName());
        view.setEmail(user.getEmail());
        view.setRole(user.getRole() != null ? user.getRole().name() : null); // enum to String
        return view;
    }
}