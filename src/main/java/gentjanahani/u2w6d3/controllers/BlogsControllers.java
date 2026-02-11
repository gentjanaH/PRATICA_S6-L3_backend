package gentjanahani.u2w6d3.controllers;

import gentjanahani.u2w6d3.entities.Authors;
import gentjanahani.u2w6d3.entities.Blogs;
import gentjanahani.u2w6d3.payloads.NewAuthorPayload;
import gentjanahani.u2w6d3.payloads.NewBlogPayload;
import gentjanahani.u2w6d3.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogsControllers {
    private final BlogsService blogsService;

    @Autowired
    public BlogsControllers(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    // 1. POST http://localhost:3002/blogs (+ Payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blogs createBlog(@RequestBody NewBlogPayload payload) {
        return this.blogsService.save(payload);
    }
}
