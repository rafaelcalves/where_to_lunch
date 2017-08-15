package com.sap.wtl.daos;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;

public interface VoteDao {
    void saveOrUpdate(Vote vote);

    void delete(Vote vote);

    Vote getVote(int id);

    Vote findByUserId(int pollId, int userId);
}
