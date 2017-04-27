package xtu.library.service.readercard;

import xtu.library.entity.ReaderCard;

public interface IReaderCardService {
	/**
	 * 保存借阅证
	 * @return
	 */
	boolean saveReaderCard(ReaderCard readercard);
	
	/**
	 * 通过id来得到借书证
	 * @param rId
	 * @return
	 */
	ReaderCard getReaderCardById(Integer rId);
	
	/**
	 * 更新借阅证信息
	 * @param readerCard
	 * @return
	 */
	boolean updateReaderCard(ReaderCard readerCard);

}
