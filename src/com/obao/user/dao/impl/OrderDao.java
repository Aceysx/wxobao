package com.obao.user.dao.impl;

import com.obao.user.dao.IOrderDao;
import com.obao.user.entity.Order;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.Map;

/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class OrderDao implements IOrderDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Object> findOrderByState(Integer state,Integer userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT  p.product_id,p.product_name,p.product_img,s.price,o.order_number,o.code,o.number,o.finish_time,o.flavor,o.remark,o.size FROM t_order o");
		sql.append(" LEFT JOIN(SELECT * FROM t_product) p ON p.product_id = o.product_id");
		sql.append(" LEFT JOIN(SELECT * FROM t_product_size) s ON s.product_id = o.product_id AND s.size = o.size");
		sql.append(" WHERE o.user_id = ").append(userId).append(" AND o.state = ").append(state);
        List<Object> list = sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }

	@Override
	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}
}
