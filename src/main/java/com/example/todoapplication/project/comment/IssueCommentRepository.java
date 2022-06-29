package com.example.todoapplication.project.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCommentRepository extends JpaRepository<IssueComment,Long> {
}
