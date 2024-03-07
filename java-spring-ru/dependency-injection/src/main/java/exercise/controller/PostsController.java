package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Post;
import exercise.repository.CommentRepository;
import exercise.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable long id, @RequestBody Post updateData) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(updateData.getTitle());
        post.setBody(updateData.getBody());
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }
}
// END
