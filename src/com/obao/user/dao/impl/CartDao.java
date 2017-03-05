package com.obao.user.dao.impl;

import com.obao.user.entity.ProductItem;
import org.hibernate.SessionFactory;

import com.obao.user.dao.ICartDao;
import com.obao.user.entity.Cart;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class CartDao implements ICartDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Override
	public void save(ProductItem productItem) {
		sessionFactory.getCurrentSession().save(productItem);
	}

	@Override
	public List<Object> findCart(String userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT pi.product_item_id,b.business_id,b.photo,b.name,p.product_id,p.product_img,p.product_name,pi.price,pi.product_number,pi.size_and_product,pi.flavor_and_product FROM t_product_item pi ");
        sql.append(" left join(select business_id,photo,name from t_business) b on b.business_id = pi.business_id ");
        sql.append(" left join(select product_id,product_img,product_name from t_product) p on p.product_id = pi.product_id ");
        sql.append(" where user_id ='").append(userId).append("' order by b.business_id desc");
        return  sessionFactory.getCurrentSession().createSQLQuery(sql.toString())
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public void deleteProductItem(ProductItem item) {
		sessionFactory.getCurrentSession().delete(item);
	}


	@Override
	public void deleteCart(Integer cartId) {
		sessionFactory.getCurrentSession().createQuery("delete from Cart where cartId=?").setParameter(0,cartId).executeUpdate();
	}

    @Override
    public ProductItem findProductItem(ProductItem item) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM t_product_item where product_id =").append(item.getProductId());
        sql.append(" and flavor_and_product ='").append(item.getFlavorAndProduct());
        sql.append("' and size_and_product='").append(item.getSizeAndProduct());
        sql.append("' and user_id='").append(item.getUserId()).append("'");
        return (ProductItem) sessionFactory.getCurrentSession().createSQLQuery(sql.toString())
                .addEntity(ProductItem.class)
                .uniqueResult();
    }
}
