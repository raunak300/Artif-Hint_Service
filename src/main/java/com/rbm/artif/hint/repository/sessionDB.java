package com.rbm.artif.hint.repository;

import com.rbm.artif.hint.Entity.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface sessionDB extends MongoRepository<Session,String> {
    public Optional findBySessionId(String sessionId);

}
