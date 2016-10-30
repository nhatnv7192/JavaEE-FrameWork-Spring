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

import entities.product;

public class handlingProduct {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<product> selectProduct(String query)
	{
		return jdbcTemplate.query(query, new ResultSetExtractor<List<product>>(){

			public List<product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<product> listProduct = new ArrayList<product>();
				while(rs.next())
				{
					product pr = new product();
					pr.setProductId(rs.getInt(1));
					pr.setCategoryId(rs.getInt(2));
					pr.setName(rs.getString(3));
					pr.setPrice(rs.getFloat(4));
					pr.setDiscount(rs.getInt(5));
					pr.setStatus(rs.getString(6));
					pr.setImageUrl(rs.getString(7));
					pr.setDescription(rs.getString(8));
					listProduct.add(pr);
				}
				return listProduct;
			}
			
		});
	}
	public List<product> select10RecordProduct(int idPage,int total)
	{
		String query = "select * from product limit "+idPage+","+total+"";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<product>>(){

			public List<product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<product> listProduct = new ArrayList<product>();
				while(rs.next())
				{
					product pr = new product();
					
					pr.setProductId(rs.getInt(1));
					pr.setCategoryId(rs.getInt(2));
					pr.setName(rs.getString(3));
					pr.setPrice(rs.getFloat(4));
					pr.setDiscount(rs.getInt(5));
					pr.setStatus(rs.getString(6));
					pr.setImageUrl(rs.getString(7));
					pr.setDescription(rs.getString(8));
					
					
					listProduct.add(pr);
				}
				return listProduct;
			}
			
		});
	}
	//code new method select 10 record auto redirect page
	public List<product> select10RecordProduct(int idPage,int total,String select)
	{
		String query = "select * from product where description='"+select+"' limit "+idPage+","+total+"";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<product>>(){

			public List<product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<product> listProduct = new ArrayList<product>();
				while(rs.next())
				{
					product pr = new product();
					
					pr.setProductId(rs.getInt(1));
					pr.setCategoryId(rs.getInt(2));
					pr.setName(rs.getString(3));
					pr.setPrice(rs.getFloat(4));
					pr.setDiscount(rs.getInt(5));
					pr.setStatus(rs.getString(6));
					pr.setImageUrl(rs.getString(7));
					pr.setDescription(rs.getString(8));
					
					
					listProduct.add(pr);
				}
				return listProduct;
			}
			
		});
	}
	public product selectDetail(final int id)
	{
		String query ="select * from product where productId='"+id+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<product>()
				{
					public product extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						product pr = new product();
						while(rs.next())
						{
							pr.setProductId(rs.getInt(1));
							pr.setCategoryId(rs.getInt(2));
							pr.setName(rs.getString(3));
							pr.setPrice(rs.getFloat(4));
							pr.setDiscount(rs.getInt(5));
							pr.setStatus(rs.getString(6));
							pr.setImageUrl(rs.getString(7));
							pr.setDescription(rs.getString(8));
							
						}
						return pr;
					}
				});
	}
	public boolean insertProduct(final product product)
	{
		String query ="insert into product(categoryId,name,price,discount,status,imageUrl,description) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, product.getCategoryId());
				ps.setString(2, product.getName());
				ps.setDouble(3, product.getPrice());
				ps.setFloat(4, product.getDiscount());
				ps.setString(5, product.getStatus());
				ps.setString(6, product.getImageUrl());
				ps.setString(7, product.getDescription());
				
				return ps.execute();
			}
		});
	}
	public boolean updateProduct(final product product,final int productId)
	{
		String query = "update product set categoryId=?,name=?,price=?,discount=?,status=?,imageUrl=?,description=? where productId=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, product.getCategoryId());
				ps.setString(2, product.getName());
				ps.setDouble(3, product.getPrice());
				ps.setInt(4, product.getDiscount());
				ps.setString(5, product.getStatus());
				ps.setString(6, product.getImageUrl());
				ps.setString(7, product.getDescription());
				ps.setInt(8, productId);
				return ps.execute();
			}
		});
	}
	public boolean deleteProduct(final int productDetail)
	{
		String query = "delete from product where productId=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1,productDetail );
				return ps.execute();
			}
			
		});
	}
}
