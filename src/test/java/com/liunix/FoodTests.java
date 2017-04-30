package com.liunix;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.liunix.controller.FoodApiTest;
import com.liunix.controller.FoodControllerTest;
import com.liunix.dao.FoodDaoTest;

@RunWith(Suite.class)
@SuiteClasses({ FoodDaoTest.class,FoodControllerTest.class,FoodApiTest.class })
public class FoodTests {

}