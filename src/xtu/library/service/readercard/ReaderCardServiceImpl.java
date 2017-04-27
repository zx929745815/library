package xtu.library.service.readercard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtu.library.dao.readercard.IReaderCardDao;
import xtu.library.entity.ReaderCard;

@Service(value = "readerCardService")
public class ReaderCardServiceImpl implements IReaderCardService{
	
	@Autowired
	private IReaderCardDao readerCardDao;

	@Override
	public boolean saveReaderCard(ReaderCard readercard) {
		// TODO Auto-generated method stub
		try {
			readerCardDao.save(readercard);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ReaderCard getReaderCardById(Integer rId) {
		// TODO Auto-generated method stub
		try {
		 return	readerCardDao.getReaderCardById(rId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateReaderCard(ReaderCard readerCard) {
		// TODO Auto-generated method stub
		try {
			readerCardDao.update(readerCard);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
