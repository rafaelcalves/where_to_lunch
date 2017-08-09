package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.VotingDao;
import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Voting;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class HibernateVotingDao extends HibernateDaoSupport implements VotingDao{

    @Override
    public void save(Voting voting) {
        getHibernateTemplate().save(voting);
    }

    @Override
    public void update(Voting voting) {
        getHibernateTemplate().update(voting);
    }

    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getVoting(id));
    }

    @Override
    public Voting getVoting(int id) {
        return getHibernateTemplate().get(Voting.class,id);
    }

    @Override
    public Establishment getMostVotedEstablishment(int votingId) {
        String queryString = "FROM com.sap.wtl.models.Vote WHERE voting_id = :pVotingId GROUP BY establishment_id ORDER BY count(establishment_id)";
        return (Establishment) getHibernateTemplate().findByNamedQueryAndNamedParam(queryString,"pVotingId",votingId);
    }

    @Override
    public List<Vote> listVotes(int votingId) {
        String queryString = "FROM com.sap.wtl.models.Vote WHERE voting_id = :pVotingId";
        return (List<Vote>) getHibernateTemplate().findByNamedQueryAndNamedParam(queryString,"pVotingId",votingId);
    }
}
