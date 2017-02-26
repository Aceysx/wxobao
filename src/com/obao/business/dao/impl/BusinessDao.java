package com.obao.business.dao.impl;

import com.obao.business.dao.IBusinessDao;
import com.obao.business.entity.Business;
import com.obao.business.entity.BusinessDomain;
import com.obao.business.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */
public class BusinessDao implements IBusinessDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	@Override
	public List<BusinessDomain> findDomains() {
		return  sessionFactory.getCurrentSession().createQuery("from BusinessDomain").list();
	}

    @Override
    public List<Object> findBusinessById(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select b.name,b.address,b.phone,b.photo,b.remark,p.product_id,p.product_name,p.product_img,p.old_price,p.new_price,p.sales ");
        sql.append(" from t_product p ");
        sql.append(" left join(select name,business_id,address,phone,photo,remark from t_business) b on p.business_id = b.business_id ");
        sql.append(" where p.business_id=").append(id).append(" order by p.sales desc");
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<Object> findBusinessList(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT b.business_id,photo,name,remark,p.sales FROM t_business b ");
        sql.append(" LEFT JOIN (select t.business_id,sum(t.sales) sales from t_product t group by t.business_id) p on p.business_id = b.business_id ");
        sql.append(" where domain_id =").append(id).append(" order by p.sales desc");
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public Integer findBusinessIdByProduct(Product product) {
        String sql = "SELECT  business_id from t_product where product_id="+product.getProductId();
        Integer businessId = (Integer) sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).uniqueResult();
       return businessId;
    }
}
