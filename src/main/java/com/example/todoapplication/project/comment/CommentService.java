package com.example.todoapplication.project.comment;

import com.example.todoapplication.user.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final TodoCommentRepository todoCommentRepository;
    private final IssueCommentRepository issueCommentRepository;

    public IssueComment issueCreateComment(Long issueId, String content, Account account){
        IssueComment comment = new IssueComment(account.getId(),content,issueId);

        return issueCommentRepository.save(comment);
    }
}
