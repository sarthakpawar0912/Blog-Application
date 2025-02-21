package com.blog_application.Service;

import com.blog_application.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CommentService {
    Comment createComment(Long postId,String postedBy,String content);

    List<Comment> getCommentsByPostId(Long postId);
}
