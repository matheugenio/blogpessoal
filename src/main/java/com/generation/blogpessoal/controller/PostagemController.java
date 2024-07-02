package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    private static final Logger logger = Logger.getLogger(PostagemController.class.getName());

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        logger.info("Received request for /postagens");
        List<Postagem> postagens = postagemRepository.findAll();
        logger.info("Found " + postagens.size() + " postagens");
        return ResponseEntity.ok(postagens);
    }
}
