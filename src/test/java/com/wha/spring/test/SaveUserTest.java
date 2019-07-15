package com.wha.spring.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.config.JPAConfig;
import com.wha.spring.config.WebConfig;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, JPAConfig.class })
public class SaveUserTest {

	@Autowired
	UserService us;

	@Test
	@Transactional
	@Rollback(true)
	public void test() {
		assertThat(us, instanceOf(UserService.class));

		assertThat(us.findById(1), instanceOf(User.class));
	}


}
