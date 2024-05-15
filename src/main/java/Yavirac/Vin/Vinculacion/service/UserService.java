package Yavirac.Vin.Vinculacion.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Yavirac.Vin.Vinculacion.dto.UserDto;
import Yavirac.Vin.Vinculacion.entity.UserEntity;
import Yavirac.Vin.Vinculacion.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    //Crear
    public UserDto getUser(String username) {

        UserEntity user = this.userRepository.findByUsername(username).orElseThrow();

        UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .build();

        return userDto;
    }


    //Editar
    public void editProfile(UserDto user) {
        UserEntity userEntity = this.userRepository.findByUsername(user.getUsername()).orElseThrow();
        userEntity.setFirstName(user.getFirstName());
        this.userRepository.save(userEntity);
    }



    @Transactional
    public void createDefaultUser() {
        // Comprobar si ya existe un usuario predeterminado
        if (userRepository.findByUsername("adminNuevoPorvenir").isEmpty()) {
            // Crear el usuario predeterminado
            UserEntity defaultUser = UserEntity.builder()
                .firstName("admin")
                .lastName("admin")
                .username("admin")
                .email("admin@example.com")
                .password(passwordEncoder.encode("admin2024NuevoPorvenir")) // Codificar la contraseña
                .build();
            
            // Guardar el usuario en la base de datos
            userRepository.save(defaultUser);
        }
    }
}
