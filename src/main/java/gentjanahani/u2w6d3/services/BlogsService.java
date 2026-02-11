//package gentjanahani.u2w6d3.services;
//
//import gentjanahani.u2w6d3.entities.Authors;
//import gentjanahani.u2w6d3.entities.Blogs;
//import gentjanahani.u2w6d3.payloads.NewAuthorPayload;
//import gentjanahani.u2w6d3.payloads.NewBlogPayload;

import gentjanahani.u2w6d3.entities.Blogs;
import gentjanahani.u2w6d3.payloads.NewBlogPayload;
import gentjanahani.u2w6d3.repository.BlogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogsService {

    private final BlogsRepository blogsRepository;

    @Autowired
    public BlogsService(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    public Blogs save(NewBlogPayload payload) {

        Blogs newBlog = new Blogs(payload.getCategory(), payload.getTitle(), payload.getContent(), payload.getReadingTime(), payload.getAuthorId());
        newBlog.setCover("https://picsum.photos/200/300" + payload.getTitle() + "+" + payload.getAuthorId());

        Blogs savedBlog = this.blogsRepository.save(newBlog);

        log.info("Il blog con id " + savedBlog.getIdBlog() + " è stato salvato correttamente!");

        return savedBlog;
    }
}
