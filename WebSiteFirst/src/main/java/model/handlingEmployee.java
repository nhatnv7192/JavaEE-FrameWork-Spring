package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import entities.Employee;

public class handlingEmployee {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e)
	{
		String query = "insert into employee value('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(query);
	}
	public Boolean saveEmployeeByPreparedStatement(final Employee e)
	{
		String query = "insert into employee values(?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setDouble(3, e.getSalary());
				return ps.execute();
			}
			
		});
	}
	public int updateEmployee(Employee e)
	{
		String query = "update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"'";
		return jdbcTemplate.update(query);
	}
	public boolean updateEmployeeByPreparedStatement(final Employee e)
	{
		String query = "update employee set name=?,salary=? where id=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, e.getName());
				ps.setDouble(2, e.getSalary());
				ps.setInt(3, e.getId());
				return ps.execute();
			}
		});
	}
	public int deleteEmployee(Employee e)
	{
		String query = "delete employee where id ='"+e.getId()+"'";
		return jdbcTemplate.update(query);
	}
	public boolean deleteEmployeeByPreparedStatement(final Employee e)
	{
		String query ="delete employee where id=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				return ps.execute();
			}
			
		});
	}
}
