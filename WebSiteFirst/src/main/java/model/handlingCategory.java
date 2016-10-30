package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import entities.category;

public class handlingCategory {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<category> selectCategory()
	{
		String query = "select * from category";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<category>>(){

			public List<category> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<category> listCategory = new ArrayList<category>();
				while(rs.next())
				{
					category ct = new category();
					ct.setCategoryId(rs.getInt(1));
					ct.setName(rs.getString(2));
					ct.setStatus(rs.getString(3));
					listCategory.add(ct);
				}
				return listCategory;
			}
			
		});
	}
	public boolean insertCategory(final String name,final String status)
	{
		String query = "insert into category(name,status) values(?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1,name);
				ps.setString(2,status);
				return ps.execute();
			}
		});
	}
	public boolean deleteCategory(final int categoryId)
	{
		String query ="delete from category where categoryId=?";
		
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, categoryId);
				return ps.execute();
			}
		});
	}
	public boolean updateCategory(final category category)
	{
		String query = "update category set name=?,status=? where categoryId=?";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, category.getName());
				ps.setString(2, category.getStatus());
				return ps.execute();
			}
		
		});
	}
}
