package com.obao.dao.impl;


import com.obao.dao.ICollectDao;
import com.obao.entity.Collect;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class CollectDao implements ICollectDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Collect collect) {
        sessionFactory.getCurrentSession().saveOrUpdate(collect);
    }

    @Override
    public List<Object> findUserAllCollect(String userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT p.product_id,p.product_name,p.product_img,p.sales,p.new_price FROM t_product p ");
        sql.append(" left join(select user_id,product_id from t_collect) c on c.user_id ='").append(userId);
        sql.append("' where p.product_id = c.product_id ");
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<Collect> isExist(Integer productId, String userId) {
       return  sessionFactory.getCurrentSession().createQuery("from Collect c where userId=? and productId=?")
                .setParameter(0, userId)
                .setParameter(1, productId)
                .list();
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM t_collect WHERE collect_id =?").setParameter(0,id).executeUpdate();
    }


}
