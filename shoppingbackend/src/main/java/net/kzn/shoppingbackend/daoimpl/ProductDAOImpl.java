package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {

		try {
			return (Product) sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Product> list() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product");

		return query.list();

	}

	/*
	 * INSERT
	 */
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	/*
	 * UPDATE
	 */
	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	/*
	 * DELETE
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts).setParameter("active", true).list();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory)
				.setParameter("active", true).setParameter("categoryId", categoryId).list();

	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER BY id")
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).list();

	}

}
