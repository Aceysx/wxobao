package com.obao.user.dao.impl;

import com.obao.user.entity.BusinessItem;
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
	public void save(BusinessItem businessItem) {
		sessionFactory.getCurrentSession().save(businessItem);
	}

	@Override
	public void save(ProductItem productItem) {
		sessionFactory.getCurrentSession().save(productItem);
	}

	@Override
	public void updateProductItem(Integer number,Integer productItemId) {
		sessionFactory.getCurrentSession().createQuery("update ProductItem set productNumber=productNumber+"+number+"  where productItemId=?")
				.setParameter(0,productItemId)
				.executeUpdate();
	}

	@Override
	public List<Object> findCart(Integer userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT pi.product_item_id,b.business_id,b.photo,b.name,p.product_id,p.product_img,p.product_name,pi.price,pi.product_number,pi.size_and_product,pi.flavor_and_product FROM t_product_item pi ");
        sql.append(" left join(select business_id,photo,name from t_business) b on b.business_id = pi.business_id ");
        sql.append(" left join(select product_id,product_img,product_name from t_product) p on p.product_id = pi.product_id ");
        sql.append(" where user_id =").append(userId).append(" order by b.business_id desc");
        return  sessionFactory.getCurrentSession().createSQLQuery(sql.toString())
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public void deleteProductItem(ProductItem item) {
		sessionFactory.getCurrentSession().delete(item);
	}

	@Override
	public void deleteBusinessItem(Integer businessItemId) {
		sessionFactory.getCurrentSession().createQuery("delete from BusinessItem where businessItemId=?")
				.setParameter(0,businessItemId).executeUpdate();
	}

	@Override
	public void deleteCart(Integer cartId) {
		sessionFactory.getCurrentSession().createQuery("delete from Cart where cartId=?").setParameter(0,cartId).executeUpdate();
	}

	@Override
	public ProductItem findProductItem(Integer productItemId) {
		return (ProductItem) sessionFactory.getCurrentSession().get(ProductItem.class,productItemId);
	}

	@Override
	public boolean checkBusinessItemIsExistProductItem(Integer businessItemId) {
		Boolean flag = false;
		long  count = (long) sessionFactory.getCurrentSession().createQuery("select count(*) from ProductItem pt where pt.businessItem.businessItemId=?").setParameter(0,businessItemId).uniqueResult();
		if(count>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean checkCartIsExistBusinessItem(Integer businessItemId) {
		Boolean flag = false;
		BusinessItem businessItem = (BusinessItem) sessionFactory.getCurrentSession().load(BusinessItem.class,businessItemId);
		Integer cartId = businessItem.getCart().getCartId();
		long count = (long) sessionFactory.getCurrentSession().createQuery("select count(*) from BusinessItem b where b.cart.cartId=?").setParameter(0,cartId).uniqueResult();
		if(count>0){
			flag = true;
		}else{
			sessionFactory.getCurrentSession().createQuery("delete from Cart where cartId=?").setParameter(0,cartId).executeUpdate();
		}
		return flag;
	}

	@Override
	public BusinessItem findBusinessItemById(Integer businessItemId) {
		return (BusinessItem) sessionFactory.getCurrentSession().get(BusinessItem.class,businessItemId);
	}

	@Override
	public BusinessItem findBusinessItemsId(Integer userId, Integer businessId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_business_item where cart_id = ").append(userId).append(" and business_id =").append(businessId);
        return (BusinessItem) sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).addEntity(BusinessItem.class).uniqueResult();
    }

    @Override
    public ProductItem findProductItem(ProductItem item) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM t_product_item where product_id =").append(item.getProductId());
        sql.append(" and flavor_and_product ='").append(item.getFlavorAndProduct());
        sql.append("' and size_and_product='").append(item.getSizeAndProduct());
        sql.append("' and user_id=").append(item.getUserId());
        return (ProductItem) sessionFactory.getCurrentSession().createSQLQuery(sql.toString())
                .addEntity(ProductItem.class)
                .uniqueResult();
    }


}
