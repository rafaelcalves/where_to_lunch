package com.sap.wtl.daos;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Poll;

import java.util.List;

public interface PollDao {
    void save(Poll poll);

    void update(Poll poll);

    void delete(int id);

    Poll getPoll(int id);

    List<Vote> listVotes(int pollId);

    List<Poll> listAll();

    List<User> listVotedUsers(int pollId);

    List<User> listVotedUsers(int pollId, int establishmentId);

    Poll findById(int pollId);

    List listOrderedEstablishmentIds(int pollId, boolean justVoted, String searchLike);
}
