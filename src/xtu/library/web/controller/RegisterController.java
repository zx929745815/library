package xtu.library.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xtu.library.entity.Reader;
import xtu.library.service.reader.IReaderService;
import xtu.library.service.reader.ReaderServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	IReaderService readerService = new ReaderServiceImpl();
	
	@RequestMapping("/toRegister")
	public String register(Reader reader){
		try {
			readerService.register(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "regSuccess";		
	}

}
