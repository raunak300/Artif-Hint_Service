package com.rbm.artif.hint.repository;

import com.rbm.artif.hint.Entity.Hints;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface hintsDB extends MongoRepository<Hints,String> {
}
