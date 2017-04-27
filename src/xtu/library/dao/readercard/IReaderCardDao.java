package xtu.library.dao.readercard;

import xtu.library.dao.base.IBaseDao;
import xtu.library.entity.ReaderCard;

public interface IReaderCardDao extends IBaseDao{
	/**
	 * 根据id来得到ReaderCard
	 * @param rId
	 * @return
	 * @throws Exception
	 */
   ReaderCard getReaderCardById(Integer rId) throws Exception;
   
}
