package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.PollDao;
import com.sap.wtl.models.User;
import com.sap.wtl.models.Vote;
import com.sap.wtl.models.Poll;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import java.util.List;

public class HibernatePollDao extends HibernateDaoSupport implements PollDao{

    @Override
    public void save(Poll poll) {
        getHibernateTemplate().save(poll);
    }

    @Override
    public void update(Poll poll) {
        getHibernateTemplate().update(poll);
    }

    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getPoll(id));
    }

    @Override
    public Poll getPoll(int id) {
        return getHibernateTemplate().get(Poll.class,id);
    }

    @Override
    public List<Vote> listVotes(int pollId) {
        String queryString = "FROM com.sap.wtl.models.Vote WHERE poll_id = :pPollId";
        return (List<Vote>) getHibernateTemplate().findByNamedParam(queryString,"pPollId",pollId);
    }

    @Override
    public List<Poll> listAll() {
        return (List<Poll>) getHibernateTemplate().find("FROM com.sap.wtl.models.Poll as A order by (CASE WHEN chosenestablishment_id IS NULL THEN 1 ELSE 0 END) desc,ending_date desc");
    }

    @Override
    public List<User> listVotedUsers(int pollId) {
        return queryUsers(pollId,0);
    }

    @Override
    public List<User> listVotedUsers(int pollId, int establishmentId) {
        return queryUsers(pollId, establishmentId);
    }

    @Override
    public Poll findById(int pollId) {
        String queryString = "FROM com.sap.wtl.models.Poll WHERE id = ?";
        return (Poll) getHibernateTemplate().find(queryString,pollId).get(0);
    }

    @Override
    public List listOrderedEstablishmentIds(int pollId, boolean justVoted) {

        String joinType = justVoted ? "inner" : "left";
        String queryString = "select a.id , count(b.establishment.id) "+
                            "from com.sap.wtl.models.Establishment as a "+
                            joinType + " join com.sap.wtl.models.Vote b "+
                                "on b.establishment.id = a.id "+
                                "and b.poll.id = :pPollId "+
                            "group by a.id, a.name "+
                            "order by count(b.establishment.id) desc, a.name, a.id";
        try{
            return currentSession().createQuery(queryString).setParameter("pPollId",pollId).list();
        }catch(Exception e){
            return null;
        }
    }

    public List<User> queryUsers(int pollId, int establishmentId){
        String sqlWhere = pollId != 0 ? " AND poll_id = " + pollId : "";
        sqlWhere += establishmentId != 0 ? " AND establishment_id = " + establishmentId : "";
        String queryString = "FROM com.sap.wtl.models.User AS A WHERE EXISTS(SELECT 1 FROM com.sap.wtl.models.Vote WHERE user_id = A.id " + sqlWhere + ")";
        return (List<User>) getHibernateTemplate().find(queryString);
    }
}
