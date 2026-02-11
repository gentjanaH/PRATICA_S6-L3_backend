package gentjanahani.u2w6d3.services;

import gentjanahani.u2w6d3.entities.Authors;
import gentjanahani.u2w6d3.exceptions.BadRequestException;
import gentjanahani.u2w6d3.payloads.NewAuthorPayload;
import gentjanahani.u2w6d3.repository.AuthorsRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Authors save(NewAuthorPayload payload) {
        this.authorsRepository.findByEmail(payload.getEmail()).ifPresent(author -> {
            throw new BadRequestException("L'email " + author.getEmail() + " è già in uso!");
        });

        Authors newAuthor = new Authors(payload.getName(), payload.getSurname(), payload.getEmail(), payload.getDateOfBirth());
        newAuthor.setAvatar("https://ui-avatars.com/api?name=" + payload.getName() + "+" + payload.getSurname());

        Authors savedAuthor = this.authorsRepository.save(newAuthor);

        log.info("L'autore con id " + savedAuthor.getIdAutore() + " è stato salvato correttamente!");

        return savedAuthor;
    }
}
