package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.VoteDao;
import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class HibernateVoteDao extends HibernateDaoSupport implements VoteDao {
    @Override
    public void saveOrUpdate(Vote vote) {
        getHibernateTemplate().saveOrUpdate(vote);
    }

    @Override
    public void delete(Vote vote) {
        getHibernateTemplate().delete(vote);
    }

    @Override
    public Vote getVote(int id) {
        return getHibernateTemplate().get(Vote.class, id);
    }

    @Override
    public Vote findByUserId(int pollId, int userId) {
        String queryString = "FROM com.sap.wtl.models.Vote WHERE poll_id = ? AND user_id = ?";
        try {
            return (Vote) getHibernateTemplate().find(queryString,pollId,userId).get(0);
        }catch(Exception e){
            return null;
        }
    }

}
