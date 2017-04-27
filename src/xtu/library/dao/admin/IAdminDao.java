package xtu.library.dao.admin;

import java.util.List;

import xtu.library.entity.Administrator;

public interface IAdminDao {
	public List<Administrator> findByName(String name);
	public void saveAdmin(Administrator admin);

}
