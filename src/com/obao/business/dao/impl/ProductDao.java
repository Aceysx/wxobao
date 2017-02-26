package com.obao.business.dao.impl;

import com.obao.business.dao.IProductDao;
import com.obao.business.entity.*;

import com.obao.user.entity.Banner;
import com.obao.user.entity.Cart;
import com.obao.user.entity.Collect;
import com.obao.user.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
public class ProductDao implements IProductDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll(Integer state) {
        return sessionFactory.getCurrentSession().createQuery("from Product where state= ? ")
                .setParameter(0,state).list();
    }

    @Override
    public Product findById(Integer productId) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class,productId);
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);

    }

    @Override
    public List<ProductSort> findAllProductSort() {
        return sessionFactory.getCurrentSession().createQuery("from ProductSort").list();
    }

    @Override
    public List<Business> findAllBusinesss() {
        return sessionFactory.getCurrentSession().createQuery("from Business").list();
    }

    @Override
    public List<Product> searchProductList(String content) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from t_product  where product_name like ? ").addEntity(Product.class)
                .setParameter(0,"%"+content+"%").list();
    }

    @Override
    public List<Object> findProtions() {
        String sql;
        sql = "SELECT product_id,product_name,product_img,new_price,sales FROM t_product WHERE promotion = 1";
        return sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<Product> findHotProducts(Integer num) {
        String sql = "SELECT product_id,product_name,product_img,new_price,sales  FROM t_product ORDER BY sales DESC LIMIT 0,"+num;
        return sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<Product> findFootprints(Integer userId) {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT p.* FROM t_footprint f\n" +
                "LEFT JOIN(SELECT * FROM t_product) p ON  f.product_id = p.product_id\n" +
                "WHERE f.user_id = ?  ORDER BY  f.add_time DESC  limit 0,10").addEntity(Product.class)
                .setParameter(0,userId)
                .list();
    }

    @Override
    public List<Banner> findBanners() {

        return sessionFactory.getCurrentSession().createQuery("from Banner where show = 1").list();
    }

    @Override
    public Object findDetailById(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT p.product_id,p.product_name,p.product_img,p.new_price,p.old_price,p.sales,p.remark,b.* FROM t_product p ");
        sql.append(" left join(select business_id,name from t_business) b on b.business_id = p.business_id ");
        sql.append(" where p.product_id = ").append(id);
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
    }

    @Override
    public List<Object> findFlavor(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select f.flavor_id,f.name from t_flavor_and_product p ");
        sql.append(" left join(select * from t_product_flavor ) f on f.flavor_id = p.flavor_id ");
        sql.append(" where p.product_id =").append(id);
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<Object> findSize(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select p.size_id,s.size,p.price from t_size_and_product p");
        sql.append(" left join (select * from t_product_size) s on s.size_id = p.size_id");
        sql.append(" where p.product_id =").append(id);
        return sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public List<BusinessDomain> findDomains() {
        return sessionFactory.getCurrentSession().createQuery("from BusinessDomain").list();
    }

    @Override
    public ProductSize findBySizeId(Integer id) {
        return (ProductSize) sessionFactory.getCurrentSession().get(ProductSize.class,id);
    }

    @Override
    public Business findAllBusinesss(Integer id) {
        return (Business) sessionFactory.getCurrentSession().createSQLQuery("SELECT b.* FROM t_product p\n" +
                "LEFT JOIN(SELECT * FROM t_business) b ON b.business_id = p.business_id\n" +
                "WHERE p.product_id = ?").addEntity(Business.class).setParameter(0,id).list().get(0);
    }

    @Override
    public List<Collect> isCollect(Integer id, Integer userId) {
        return sessionFactory.getCurrentSession().createQuery("from Collect c where c.user.userId=? and c.product.productId=?")
                .setParameter(0,userId)
                .setParameter(1,id).list();
    }
}
