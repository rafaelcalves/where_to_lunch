package com.sap.wtl.services;

import com.sap.wtl.models.Vote;

public interface VoteService {
    void createEdit (Vote vote);

    void edit (Vote vote);

    void delete (Vote vote);

    Vote findByUserId (int pollId, int userId);

    Vote getVote (int voteId);

}
