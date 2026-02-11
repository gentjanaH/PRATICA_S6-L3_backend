//package gentjanahani.u2w6d3.services;
//
//import gentjanahani.u2w6d3.entities.Authors;
//import gentjanahani.u2w6d3.entities.Blogs;
//import gentjanahani.u2w6d3.payloads.NewAuthorPayload;
//import gentjanahani.u2w6d3.payloads.NewBlogPayload;

import gentjanahani.u2w6d3.entities.Authors;
import gentjanahani.u2w6d3.entities.Blogs;
import gentjanahani.u2w6d3.payloads.NewBlogPayload;
import gentjanahani.u2w6d3.repository.AuthorsRepository;
import gentjanahani.u2w6d3.repository.BlogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BlogsService {

    private final BlogsRepository blogsRepository;
    private final AuthorsRepository authorsRepository;

    @Autowired
    public BlogsService(BlogsRepository blogsRepository, AuthorsRepository authorsRepository) {
        this.blogsRepository = blogsRepository;
        this.authorsRepository = authorsRepository;
    }

    public Blogs save(NewBlogPayload payload) {
        Authors authorFromDb = authorsRepository.findById(UUID.fromString(payload.getAuthorId()))
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));


        Blogs newBlog = new Blogs(payload.getCategory(), payload.getTitle(), payload.getContent(), payload.getReadingTime());

        newBlog.setAuthor(authorFromDb);
        newBlog.setCover("https://picsum.photos/200/300" + payload.getTitle() + "+" + payload.getAuthorId());

        Blogs savedBlog = this.blogsRepository.save(newBlog);

        log.info("Il blog con id " + savedBlog.getIdBlog() + " è stato salvato correttamente!");

        return savedBlog;
    }
}
