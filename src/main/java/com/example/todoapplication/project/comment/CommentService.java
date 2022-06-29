package com.example.todoapplication.project.comment;

import com.example.todoapplication.project.issue.Issue;
import com.example.todoapplication.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final TodoCommentRepository todoCommentRepository;
    private final IssueCommentRepository issueCommentRepository;

    public IssueComment issueCreateComment(Long issueId, String content, User user){
        IssueComment comment = new IssueComment(user.getId(),content,issueId);

        return issueCommentRepository.save(comment);
    }
}
