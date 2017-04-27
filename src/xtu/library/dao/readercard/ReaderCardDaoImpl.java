package xtu.library.dao.readercard;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.ReaderCard;

@Repository(value = "readerCardDao")
public class ReaderCardDaoImpl extends BaseDao implements IReaderCardDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ReaderCard getReaderCardById(Integer rId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select rc from ReaderCard rc left join  rc.reader r where r.rId = :id";
		Query query = session.createQuery(hql).setParameter("id", rId);
		ReaderCard readerCard = (ReaderCard) query.getSingleResult();
		session.close();
		return readerCard;
	}



}
