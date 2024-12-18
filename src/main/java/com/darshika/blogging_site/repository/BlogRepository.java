package com.darshika.blogging_site.repository;

import com.darshika.blogging_site.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
  List<Blog> findByUsername(String username);

  void deleteById(Long id);
}
