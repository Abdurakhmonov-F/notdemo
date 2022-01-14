package com.example.notdemo.service;

import com.example.notdemo.domain.UserEntity;
import com.example.notdemo.exception.AlreadyExistsException;
import com.example.notdemo.exception.DoesNotExistException;
import com.example.notdemo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.example.notdemo.domain.inner.UserRole.ADMIN;
import static com.example.notdemo.util.Constants.UZB_MOBILE_CODE;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
public class UserService {
        private static final Logger LOGGER = LogManager.getLogger();
    private static final String MOBILE_NUMBERS_PATTERN =
            "^(\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";


        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
//        private final ObjectMapper objectMapper;
//        private final CacheManager cacheManager;

        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
                this.userRepository = userRepository;
                this.passwordEncoder = passwordEncoder;

        }
  //  public Flux<UserEntity> insertAllUserDeletedFalse(){
  //      return userRepository.insertAllUserDeletedFalse();
  //  }

    public Mono<Void> block(final String id, final boolean block) {
        Assert.notNull(id, "User ID cannot be null");

        return userRepository
                .findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new DoesNotExistException(String.format("User with [%s] ID doesn't exists", id))))
                .flatMap(
                        user -> {
                            user.setEnabled(!block);
                            return userRepository.save(user);
                        })
                .doOnSuccess(
                        user ->
                                LOGGER.info(
                                        "{} user has been " + (block ? "" : "un") + "blocked!", user.getUsername()))
                .then();
    }
//    private boolean isValidUzbNumber(final String number) {
//        if (number.startsWith(UZB_MOBILE_CODE)) {
//            return number.length() == 12;
//        } else {
//            return true;
//        }
//    }
        public Mono<UserEntity> signup(final UserEntity user){
                Assert.notNull(user, "User can't be null");
                Assert.notEmpty(user.getAuthorities(), "User must have at least a single role");
//            Assert.isTrue(
//                    Pattern.matches(MOBILE_NUMBERS_PATTERN, user.getUsername()),
//                    "Phone number has a wrong format");
//            Assert.isTrue(isValidUzbNumber(user.getUsername()));
                final String username = user.getUsername();
                if (user.getRole().contains(ADMIN)){
                        LOGGER.error(
                                "{} {} [{}] cannot set himself as ADMIN", user.getFirstName() , user.getLastName() , username
                        );
                       Mono.error(
                               new ResponseStatusException(FORBIDDEN, "Forbidden to have an explicit ADMIN role")
                       );
                }
                LOGGER.debug(
                        "{} {} [{}] user with {} roles is signing up ",
                        user.getFirstName(),
                        user.getLastName(),
                        username,
                        user.getAuthorities());
              return userRepository
                      .existsByUsernameAndDeleted(username)
                      .flatMap(
                              foundUser -> {
                                      if (!foundUser){
                                              final Instant now = Instant.now();
                                              final UserEntity userEntity = new UserEntity();
                                              userEntity.setId(UUID.randomUUID().toString());
                                             // userEntity.setFirstName(user.getFirstName());
                                             // userEntity.setLastName(user.getLastName());
                                             // userEntity.setUsername(user.getUsername());
                                             // userEntity.setRole(user.getRole());
                                              userEntity.setVerified(false);
                                              userEntity.setCreatedBy("system");
                                              userEntity.setLastModifiedBy("system");
                                              userEntity.setCreatedDate(now);
                                              userEntity.setLastModifiedDate(now);
                                              userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
                                              return userRepository.save(userEntity);
                                      }
                                      final String errorMsg = String.format("%s already exits in the system", username);
                                      LOGGER.error(errorMsg);
                                      return Mono.error(new AlreadyExistsException(errorMsg));
                              })

                      .doOnSuccess(
                              user1 ->
                                      LOGGER.info(
                                              "Following user with [{}] username has signed up: {}",
                                              username,
                                              user.getPassword()

                                              )
                      );
        }
 }
