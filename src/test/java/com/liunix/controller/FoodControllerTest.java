package com.liunix.controller;

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
public class FoodControllerTest {

	@Autowired
	FoodController controller;

	/**
	 * 普通业务方法测试
	 */
	@Test
	public void sumTest() {
		int result = controller.sum(1, 2);
		assertEquals(result, 3);
	}

	@Test
	public void foodByNameTest() {
		List<Food> foods = controller.foodByName("白");
		assertEquals(foods.size(), 1);
	}

}
