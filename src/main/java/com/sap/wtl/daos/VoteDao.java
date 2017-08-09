package com.sap.wtl.daos;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;

public interface VoteDao {
    void saveOrUpdate(Vote vote);

    void delete(int id);

    Vote getVote(int id);
}
