package com.darshika.blogging_site.service;

import com.darshika.blogging_site.entity.Blog;
import com.darshika.blogging_site.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

  private final BlogRepository blogRepository;

  @Autowired
  public BlogService(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  public List<Blog> getAllBlogsByUser(String username) {
    return blogRepository.findByUsername(username);
  }

  public Blog saveBlog(Blog blog) {
    return blogRepository.save(blog);
  }

  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
  }
}
