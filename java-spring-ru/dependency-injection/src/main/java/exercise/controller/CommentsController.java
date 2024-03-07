package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment show(@PathVariable long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment post) {
        return commentRepository.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment update(@PathVariable long id, @RequestBody Comment updateData) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        comment.setPostId(updateData.getPostId());
        comment.setBody(updateData.getBody());
        return commentRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        commentRepository.deleteById(id);
    }
}
// END
