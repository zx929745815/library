package xtu.library.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtu.library.dao.admin.IAdminDao;
import xtu.library.entity.Administrator;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public List<Administrator> findByName(String name) {
		List<Administrator> adminList =adminDao.findByName(name);
		return adminList;
	}

}
