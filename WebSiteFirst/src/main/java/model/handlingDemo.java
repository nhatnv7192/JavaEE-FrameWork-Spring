package model;

import org.springframework.jdbc.core.JdbcTemplate;

public class handlingDemo {	
	//execute multipat queries
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int[] executeMultipleQuery()
	{
		return jdbcTemplate.batchUpdate(new String[] {
			"select * from category",
			"update category...",
			"insert...."
			});
	}

}
