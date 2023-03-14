package LaylaSilbernberg.PersonalBlog.blog.model;

import LaylaSilbernberg.PersonalBlog.blog.model.documents.Blog;
import LaylaSilbernberg.PersonalBlog.blog.model.dto.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BlogService {

    BlogRepository repo;

    public BlogService(@Autowired BlogRepository repo) {
        this.repo = repo;
    }

    public Blog createBlog(BlogDto blogDto) {

        return repo.saveBlog(new Blog(
                blogDto.title(),
                blogDto.body(),
                LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE),
                blogDto.keywords()));
    }

    public Page<Blog> getBlogs(Pageable pagination) {

        return repo.getBlogs(pagination);
    }
}