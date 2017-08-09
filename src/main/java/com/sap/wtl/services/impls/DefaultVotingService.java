package com.sap.wtl.services.impls;

import com.sap.wtl.daos.VotingDao;
import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Voting;
import com.sap.wtl.services.VotingService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultVotingService implements VotingService{
    @Resource
    private VotingDao hibernateVotingDao;

    @Override
    public void create(Voting voting) {
        hibernateVotingDao.save(voting);
    }

    @Override
    public void edit(Voting voting) {
        hibernateVotingDao.update(voting);
    }

    @Override
    public void delete(int id) {
        hibernateVotingDao.delete(id);
    }

    @Override
    public List<Vote> listVotes(int votingID) {
        return hibernateVotingDao.listVotes(votingID);
    }

    @Override
    public Establishment getMostVotedEstablishment(int votingId) {
        return hibernateVotingDao.getMostVotedEstablishment(votingId);
    }

    @Override
    public void endVoting(int votingId) {
        //get the voting
        Voting endingVoting = hibernateVotingDao.getVoting(votingId);
        //set the most voted establishment
        endingVoting.setChosenEstablishment(getMostVotedEstablishment(votingId));
        //update database
        edit(endingVoting);
    }
}
