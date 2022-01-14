package com.example.notdemo.repository;

import com.example.notdemo.domain.UserEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity,String> {
    @Query(value = "{ 'username' : ?0 , 'deleted': false}", exists = true)
    Mono<Boolean> existsByUsernameAndDeleted(final String username);

    @Query(value = "{ 'username' : ?0 , 'deleted': false}", exists = true)
    Mono<Boolean> existsByUsername(final String username);

    @Query("{ 'username' : ?0 , 'deleted': false}")
    Mono<UserEntity> findByUsername(final String username);

    @Query("{'deleted': false}")
    Flux<UserEntity> findAllBy();

    @Query("{'lastModifiedDate' : { $gte: ?0, $lt: ?1 }, 'deleted': false }")
    Flux<UserEntity> findAllByLastModifiedBy(Date lastModifiedDate, Date lastModifiedDate2);
  //  Flux<UserEntity> insertAllUserDeletedFalse();
}
