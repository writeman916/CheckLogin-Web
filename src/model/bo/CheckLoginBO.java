package model.bo;
import java.util.ArrayList;
import model.bean.User;
import model.dao.CheckLoginDAO;
public class CheckLoginBO {
	
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	public boolean isValidUser(String userName, String password) {		
		return checkLoginDAO.isExistUser(userName, password);
	}
	public User getUser(String userName) {
		return checkLoginDAO.getUser(userName);
	}
}
