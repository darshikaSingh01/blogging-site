package com.darshika.blogging_site.controller;

import com.darshika.blogging_site.entity.Blog;
import com.darshika.blogging_site.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Blog> blogs = blogRepository.findByUsername("demoUser");
        model.addAttribute("blogs", blogs);
        return "dashboard";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        blogRepository.deleteById(id);
        return "redirect:/blogs/dashboard";
    }

    @GetMapping("/create")
    public String createBlogPage() {
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@RequestParam("name") String name, @RequestParam("body") String body) {
        Blog blog = new Blog();
        blog.setName(name);
        blog.setBody(body);
        blog.setUsername("demoUser");
        blogRepository.save(blog);
        return "redirect:/blogs/dashboard";
    }

    @GetMapping("/report")
    public String showReport(Model model) {

        List<Blog> blogs = blogRepository.findByUsername("demoUser");

        String[] words = blogs.stream()
                .flatMap(blog -> Arrays.stream(blog.getBody().split("\\s+")))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        model.addAttribute("topWords", words);
        return "report";
    }
}
