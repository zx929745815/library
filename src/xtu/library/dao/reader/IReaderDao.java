package xtu.library.dao.reader;

import java.util.List;

import xtu.library.dao.base.IBaseDao;
import xtu.library.entity.Reader;

public interface IReaderDao extends IBaseDao{
	public void saveReader(Reader reader);
	public List<Reader> checkByName(String name);
	public List<Reader> listAllReader();
	public void updateReader(Reader reader);
	
	/**
	 * 通过学号来精确查询一个读者
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Reader findByRNo(Integer RNO) throws Exception;
	
	/**
	 * 通过id来精确匹配
	 * @param rId
	 * @return
	 */
	Reader findByRid(Integer rId) throws Exception;
	

}
