package com.example.todoapplication.project.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;

    public IssueDto createIssue(IssueDto issueDto) {
        Issue issue = issueRepository.save(issueMapper.toEntity(issueDto));
        return issueMapper.toDto(issue);
    }

    public void deleteIssue(Long issueId){
        issueRepository.deleteById(issueId);
    }

    public IssueDto updateIssue(IssueDto issueDto){
        Issue issue = issueRepository.findById(issueDto.getId()).orElseThrow(() -> new IllegalArgumentException("issue not exist"));
        issueMapper.updateFromDto(issueDto, issue);
        return issueMapper.toDto(issue);
    }


}
