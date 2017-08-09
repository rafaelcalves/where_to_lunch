package com.sap.wtl.services;

import com.sap.wtl.models.Vote;

public interface VoteService {
    void create (Vote vote);

    void edit (Vote vote);

    void delete (int voteId);

}
