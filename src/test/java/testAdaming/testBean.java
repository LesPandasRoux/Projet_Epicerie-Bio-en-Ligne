package testAdaming;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fr.adaming.model.User;
import com.fr.adaming.dao.IUserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")

public class testBean {

	@Autowired
	private IUserDAO UserDAO;

	@Test
	public void testCreateUser() {
		User user = new User();
		// user.setIdUser((long) 123);
		user.setIdUser(123);

		user.setNom("Mohamed");
		user.setPrenom("Mohamed");

		UserDAO.addUser(user);
		assertEquals(user, UserDAO.getUserById(user.getIdUser()));
	}

	@Test
	public void testGetUserById() {
		User user = UserDAO.getUserById(1);
		assertNotNull(user);
	}
}
