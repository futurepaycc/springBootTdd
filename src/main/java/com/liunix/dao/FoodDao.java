package com.liunix.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liunix.domain.Food;

@Repository
public class FoodDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Food> findFoodByName(String name) {

		name = "%" + name + "%";
		// jdk 1.8语法糖
		List<Food> result = jdbcTemplate.query("select id,name,price from food where name like ? ",
				new Object[] { name },
				(rs, rowNum) -> new Food(rs.getString("id"), rs.getString("name"), rs.getDouble("price")));
		// List<Food> result = jdbcTemplate.query("select ID,NAME,PRICE from
		// food where name like ? and merchant_id = ?", new Object[] {
		// name,MERCHANT_ID }, new BeanPropertyRowMapper<Food>(Food.class));
		return result;
	}

	public List<Map<String, Object>> findFoodById(String id) {
		List<Map<String, Object>> result = jdbcTemplate.query("select ID,NAME,PRICE from food t where t.id = ? ",
				new Object[] { id }, new ColumnMapRowMapper());
		return result;
	}

}
