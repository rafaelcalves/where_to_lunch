package com.sap.wtl.services.impls;

import com.sap.wtl.daos.VoteDao;
import com.sap.wtl.models.Vote;
import com.sap.wtl.services.VoteService;

import javax.annotation.Resource;
import java.time.LocalDateTime;

public class DefaultVoteService implements VoteService {
    @Resource
    private VoteDao hibernateVoteDao;

    @Override
    public void create(Vote vote) {
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
    public void delete(int voteId) {
        hibernateVoteDao.delete(voteId);
    }

    public LocalDateTime timeNow(){
        return  LocalDateTime.now();
    }
}
