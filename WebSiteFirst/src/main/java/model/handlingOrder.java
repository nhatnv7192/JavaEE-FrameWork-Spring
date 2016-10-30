package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import entities.order;
import entities.orderDetails;
import entities.product;

public class handlingOrder {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean insertOrder(order order)
	{
		String query = "insert into orderproduct(orderCode,orderDate,shippingCost,contactName,contactPhone,contactEmail,description) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, order.getOrderCode());
				ps.setString(2, order.getOrderDate());
				ps.setDouble(3,order.getShippingCost());
				ps.setString(4, order.getContactName());
				ps.setString(5, order.getContactPhone());
				ps.setString(6, order.getContactEmail());
				ps.setString(7, order.getDescription());
				
			return ps.execute();
				
			}
			
		});
	}
	public int selectOrderId(String orderCode)
	{
		String query = "select(orderId) from orderproduct where orderCode="+orderCode+"";
		return jdbcTemplate.queryForInt(query);
	}
	public boolean insertOrderDetail(int orderCode,int productId,int quantity,double price,double discount)
	{
		String query ="insert into orderdetails(orderId,productId,quantity,price,discount) values(?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1,orderCode);
				ps.setInt(2, productId);
				ps.setInt(3,quantity);
				ps.setDouble(4, price);
				ps.setDouble(5, discount);
				return ps.execute();
			}
			
		});
	}
	public List<order> selectOrder()
	{
		String query ="select * from orderproduct";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<order>>(){

			@Override
			public List<order> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<order> listOrder = new ArrayList<order>();
				while(rs.next())
				{
					order od = new order();
					od.setOrderId(rs.getInt(1));
					od.setOrderCode(rs.getString(2));
					od.setOrderDate(rs.getString(3));
					od.setShippingCost(rs.getDouble(4));
					od.setContactName(rs.getString(5));
					od.setContactPhone(rs.getString(6));
					od.setContactEmail(rs.getString(7));
					od.setDescription(rs.getString(8));
					
					listOrder.add(od);
				}
				return listOrder;
			}
			
		});
	}
	public List<orderDetails> selectorderDetails(int orderId)
	{
		String query ="select * from orderDetails where orderId="+orderId+"";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<orderDetails>>(){

			@Override
			public List<orderDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<orderDetails> listProduct = new ArrayList<orderDetails>();
				while(rs.next())
				{
					orderDetails od = new orderDetails();
					od.setOrderId(rs.getInt(2));
					od.setProductId(rs.getInt(3));
					od.setQuantity(rs.getInt(4));
					od.setPrice(rs.getDouble(5));
					od.setDiscount(rs.getDouble(6));
					
					listProduct.add(od);
				}
				return listProduct;
			}
			
		});
	}
}
