package com.sap.wtl.services.impls;

import com.sap.wtl.daos.VoteDao;
import com.sap.wtl.models.Vote;
import com.sap.wtl.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Transactional
public class DefaultVoteService implements VoteService {
    @Resource
    private VoteDao hibernateVoteDao;

    @Override
    public void createEdit(Vote vote) {
        vote.setLastEdit(timeNow());
        hibernateVoteDao.saveOrUpdate(vote);
    }

    @Override
    public void edit(Vote vote) {
        vote.setLastEdit(timeNow());
        vote.isEdited();
        hibernateVoteDao.saveOrUpdate(vote);
    }

    @Override
    public void delete(Vote vote) {
        hibernateVoteDao.delete(vote);
    }

    @Override
    public Vote findByUserId(int pollId, int userId) {
        return hibernateVoteDao.findByUserId(pollId,userId);
    }

    @Override
    public Vote getVote(int voteId) {
        return hibernateVoteDao.getVote(voteId);
    }

    public LocalDateTime timeNow(){
        return  LocalDateTime.now();
    }
}
