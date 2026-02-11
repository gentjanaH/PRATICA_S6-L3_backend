package gentjanahani.u2w6d3.controllers;

import gentjanahani.u2w6d3.entities.Authors;
import gentjanahani.u2w6d3.payloads.NewAuthorPayload;
import gentjanahani.u2w6d3.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsControllers {
    private final AuthorsService authorsService;

    @Autowired
    public AuthorsControllers(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }


    // 1. POST http://localhost:3002/authors (+ Payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Authors createAuthor(@RequestBody NewAuthorPayload payload) {
        return this.authorsService.save(payload);
    }
}
