package com.sap.wtl.services.impls;

import com.sap.wtl.daos.PollDao;
import com.sap.wtl.models.*;
import com.sap.wtl.services.EstablishmentService;
import com.sap.wtl.services.PollService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class DefaultPollService implements PollService{
    @Resource
    private PollDao hibernatePollDao;

    @Resource
    private EstablishmentService defaultEstablishmentService;

    @Override
    public void create(Poll poll) {
        hibernatePollDao.save(poll);
    }

    @Override
    public void edit(Poll poll) {
        hibernatePollDao.update(poll);
    }

    @Override
    public void delete(int id) {
        hibernatePollDao.delete(id);
    }

    @Override
    public List<Vote> listVotes(int pollID) {
        return hibernatePollDao.listVotes(pollID);
    }

    @Override
    public Establishment getMostVotedEstablishment(int pollId) {
        try{
            return listOrderedEstablishmentsVoted(pollId).get(0);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void endPoll(int pollId) {
        //get the poll
        Poll endingPoll = hibernatePollDao.getPoll(pollId);
        //set the most voted establishment
        endingPoll.setChosenEstablishment(getMostVotedEstablishment(pollId));
        //update database
        edit(endingPoll);
    }

    @Override
    public List<Poll> listHistory() {
        return hibernatePollDao.listAll();
    }

    @Override
    public List<User> listVotedUsers(int pollId) {
        return hibernatePollDao.listVotedUsers(pollId);
    }

    @Override
    public List<User> listVotedUsers(int pollId, int establishmentId) {
        return hibernatePollDao.listVotedUsers(pollId,establishmentId);
    }

    @Override
    public Poll findById(int pollId) {
        return hibernatePollDao.findById(pollId);
    }

    @Override
    public List<EstablishmentView> listOrderedEstablishmentsAll(int pollId) {
        return populateEstablishmentViewList(pollId,false);
    }

    @Override
    public List<EstablishmentView> listOrderedEstablishmentsVoted(int pollId) {
        return populateEstablishmentViewList(pollId,true);
    }

    public List<EstablishmentView> populateEstablishmentViewList (int pollId, boolean justVoted){
        List<EstablishmentView> establishmentsViewList = new ArrayList<EstablishmentView>();
        List orderedIds = hibernatePollDao.listOrderedEstablishmentIds(pollId,justVoted);
        for (int i = 0; i < orderedIds.size(); i++){
            Establishment establishment = defaultEstablishmentService.getEstablishment(Integer.parseInt(((Object[])orderedIds.get(i))[0].toString()));
            int countOfVotes = Integer.parseInt(((Object[])orderedIds.get(i))[1].toString());
            EstablishmentView establishmentView = new EstablishmentView(establishment,countOfVotes);
            establishmentsViewList.add(establishmentView);
        }
        return establishmentsViewList;
    }
}
