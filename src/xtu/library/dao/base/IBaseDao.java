package xtu.library.dao.base;

import java.util.List;

import javax.persistence.Query;

public interface IBaseDao {
	
	/**
	 * 存储一个对象
	 * @param t
	 * @throws Exception
	 */
	 <T> void save(T t)throws Exception;
	 /**
	  * 删除
	  * @param t
	  * @throws Exception
	  */
	 <T> void delete(T t) throws Exception;
	 /**
	  * 更新
	  * @param t
	  * @throws Exception
	  */
	 <T> void update(T t) throws Exception;
	 /**
	  * 返回所有的记录
	  * @param hql
	  * @return
	  * @throws Exception
	  */
	 <T> List<T> find(String hql) throws Exception;
	/**
	 * 得到所有记录的总条数
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	int getCount(String hql,String keywords) throws Exception;
	int getCount(String hql);
	
	/**
	 * 分页查询
	 * @param hql
	 * @param offset
	 * @param length
	 * @return
	 * @throws Exception
	 */
	<T> List<T> queryForPage(Query query,int pageindex,int length) throws Exception;
	
 
}
