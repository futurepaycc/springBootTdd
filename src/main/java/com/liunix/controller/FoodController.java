package com.liunix.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

//import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liunix.dao.FoodDao;
import com.liunix.domain.Food;

//@Configuration
// @responseBody 这个必须有
@Controller
public class FoodController {

	@Autowired
	FoodDao foodDao;

	@RequestMapping("/")
	public @ResponseBody String home() {
		return "home";
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "hello world";
	}

	@RequestMapping("/foodByName")
	public @ResponseBody List<Food> foodByName(@RequestParam String name) {
		List<Food> foods = foodDao.findFoodByName(name);
		StringBuffer sb = new StringBuffer();
		for (Food food : foods) {
			sb.append(food.getName()).append("<br>");
		}
		return foods;
	}

	/**
	 * TODO: 为快速做原型，直接将sql放出去!!!! controller接口直接用jdbcTemplate接口 客户端，angular
	 * ionic开发,vue组件化慢慢练习吧
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/foodById")
	public @ResponseBody List<Map<String, Object>> foodById(@RequestParam String id) {
		List<Map<String, Object>> findFoodByMenu = foodDao.findFoodById(id);
		return findFoodByMenu;
	}

	public int sum(int a, int b) {
		return a + b;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/findbysql")
	public @ResponseBody List<Map<String, Object>> findbysql(@RequestParam String sql, @RequestParam String[] args) {
		Object[] params = argsTranlator(args);
		List<Map<String, Object>> findFoodByMenu = jdbcTemplate.query(sql, params, new ColumnMapRowMapper());
		return findFoodByMenu;
	}

	@RequestMapping("/findbyjson")
	@SuppressWarnings("unchecked")
	public @ResponseBody List<Map<String, Object>> findbyjson(@RequestBody JSONObject jsonObject) {
		String sql = jsonObject.get("sql").toString();
		List<String> params = (List<String>) jsonObject.get("args");
		String[] args = new String[params.size()];
		for (int i = 0; i < args.length; i++) {
			args[i] = params.get(i);
		}
		List<Map<String, Object>> findFoodByMenu = jdbcTemplate.query(sql, argsTranlator(args),
				new ColumnMapRowMapper());
		return findFoodByMenu;
	}

	private Object[] argsTranlator(String[] args) {
		Object[] params = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i].split(":").length == 2) {
				if ("int".equals(args[i].split(":")[1])) {
					params[i] = Integer.parseInt(args[i].split(":")[0]);
				}
			} else {
				params[i] = args[i];
			}
		}
		return params;
	}

}
