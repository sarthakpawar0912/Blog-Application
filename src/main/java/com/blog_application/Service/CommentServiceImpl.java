package com.blog_application.Service;

import com.blog_application.Entity.Comment;
import com.blog_application.Entity.Post;
import com.blog_application.Repository.CommentRepository;
import com.blog_application.Repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Long postId,String postedBy,String content){
        Optional<Post>optionalPost=postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Comment comment=new Comment();
            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());

            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException("Post not Found");
    }


    public List<Comment> getCommentsByPostId(Long postId){
        return commentRepository.findByPostId(postId);
    }












}
