package by.epam.web.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.web.bean.Cart;
import by.epam.web.bean.Item;
import by.epam.web.dao.ConnectorDB;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.interfaces.CartDAO;

public class SQLCartDAO implements CartDAO {

	private static Logger logger = LogManager.getLogger("logger");
	@Override
	public Cart addCart(Cart cart) throws DAOException {
		Connection con = null;
		PreparedStatement ps=null;
		Statement st = null;
		ArrayList<Item> list = cart.getList();
		ResultSet rs = null;
		ArrayList<Integer> keys = new ArrayList<Integer>();
		int id_item=0;
		try{
			con = ConnectorDB.getConnection();
			ps = con.prepareStatement("INSERT INTO item (equipment_id, user_id, quantity) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			for (Item item : list){
				ps.setInt(1, item.getEquipment().getId());
				ps.setInt(2, item.getUser().getId());
				ps.setInt(3, item.getQuantity());
				ps.addBatch();
			}
			ps.executeBatch();
			rs = ps.getGeneratedKeys();
			while (rs.next()){
				id_item = rs.getInt(1);
				keys.add(id_item);
			}
			st = con.createStatement();
			rs = st.executeQuery("SELECT MAX(id) FROM cart");
			if(rs.next()) id_item = rs.getInt(1);
			id_item++;
			ps = con.prepareStatement("INSERT INTO cart (id, item_id) VALUES(?,?)");
			for (Integer key : keys){
				ps.setInt(1, id_item);
				ps.setInt(2, key);
				ps.addBatch();
			}
			ps.executeBatch();
		}catch(SQLException e){
			throw new DAOException(e);
		}
		finally{
			try {
				con.close();
				ps.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}		
		return cart;
	}

	@Override
	public int deleteCartById(int id) throws DAOException {
		return 0;
	}

}
