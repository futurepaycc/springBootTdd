package com.liunix.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.liunix.SpringTestCase;
import com.liunix.domain.Food;

@SpringTestCase
@RunWith(SpringRunner.class)
public class FoodDaoTest {

	/* dao 功能测试 */
	@Autowired
	FoodDao foodDao;

	@Test
	public void testSaveMemberCreateTime() {
		List<Food> result = foodDao.findFoodByName("白");
		assertEquals(result.size(), 1);
	}

}
