package com.sap.wtl.services;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Voting;

import java.util.List;

public interface VotingService {
    void create(Voting voting);

    void edit(Voting voting);

    void delete(int id);

    List<Vote> listVotes(int votingId);

    Establishment getMostVotedEstablishment(int votingId);

    void endVoting(int votingId);
}
