package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.VoteDao;
import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.Vote;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class HibernateVoteDao extends HibernateDaoSupport implements VoteDao {
    @Override
    public void saveOrUpdate(Vote vote) {
        getHibernateTemplate().saveOrUpdate(vote);
    }

    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getVote(id));
    }

    @Override
    public Vote getVote(int id) {
        return getHibernateTemplate().get(Vote.class, id);
    }

}
