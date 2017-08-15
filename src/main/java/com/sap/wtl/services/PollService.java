package com.sap.wtl.services;

import com.sap.wtl.models.*;

import java.util.List;

public interface PollService {
    void create(Poll poll);

    void edit(Poll poll);

    void delete(int id);

    List<Vote> listVotes(int pollId);

    Establishment getMostVotedEstablishment(int pollId);

    void endPoll(int pollId);

    List<Poll> listHistory();

    List<User> listVotedUsers(int pollId);

    List<User> listVotedUsers(int pollId, int establishmentId);

    Poll findById(int pollId);

    List<EstablishmentView> listOrderedEstablishmentsAll(int pollId);

    List<EstablishmentView> listOrderedEstablishmentsVoted(int pollId);

    List<EstablishmentView> listOrderedEstablishmentsFiltered(int pollId, boolean returnVoted, String searchLike);
}
