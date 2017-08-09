package com.sap.wtl.daos;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Voting;

import java.util.List;

public interface VotingDao {
    void save(Voting voting);

    void update(Voting voting);

    void delete(int id);

    Voting getVoting(int id);

    Establishment getMostVotedEstablishment(int votingId);

    List<Vote> listVotes(int votingId);
}
