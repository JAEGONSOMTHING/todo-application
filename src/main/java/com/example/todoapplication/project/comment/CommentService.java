package com.example.todoapplication.project.comment;

import com.example.todoapplication.user.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final TodoCommentRepository todoCommentRepository;
    private final IssueCommentRepository issueCommentRepository;

    public IssueComment CreateIssueComment(Long issueId, String content, Account account){
        IssueComment comment = new IssueComment(account.getId(),content,issueId);

        return issueCommentRepository.save(comment);
    }
    public TodoComment createTodoComment(Long todoId, String content, Account account){
        TodoComment comment = new TodoComment(account.getId(),content,todoId);
        return todoCommentRepository.save(comment);
    }
}
