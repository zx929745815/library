package xtu.library.service.reader;

import java.util.List;

import xtu.library.entity.Reader;

public interface IReaderService {
    boolean register(Reader reader);
    boolean addReader(Reader reader);
	public List<Reader> findByName(String name);
	public void updateReader(Reader reader);
	public List<Reader> listAllReader();
	
	/**
	 * 通过学号精确匹配
	 * @param rNo
	 * @return
	 */
	Reader findByRNo(Integer rNo);
	
	/**
	 * 通过id来精确匹配
	 * @param rId
	 * @return
	 */
	Reader findByRId(Integer rId);
	
	/**
	 * 通过id来删除
	 * @param rId
	 * @return
	 */
	boolean deleteReaderById(Integer rId);

}
