package xtu.library.service.admin;

import java.util.List;

import xtu.library.entity.Administrator;

public interface IAdminService {
	public List<Administrator> findByName(String name);

}
