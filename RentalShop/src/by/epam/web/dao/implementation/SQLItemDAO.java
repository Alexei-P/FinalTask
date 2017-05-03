package by.epam.web.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.web.bean.Equipment;
import by.epam.web.bean.Item;
import by.epam.web.bean.User;
import by.epam.web.dao.ConnectorDB;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.interfaces.EquipmentDAO;
import by.epam.web.dao.interfaces.ItemDAO;

import java.sql.Date;


public class SQLItemDAO implements ItemDAO {
	private static Logger logger = LogManager.getLogger("logger");
	@Override
	public void createItem(int equipment_id, int user_id, int quantity) throws DAOException {
		try (Connection con = ConnectorDB.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO sportequipmentshop.item (equipment_id, user_id, quantity) VALUES(?,?,?)");) {
			ps.setInt(1, equipment_id);
			ps.setInt(2, user_id);
			ps.setInt(3, quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/*@Override
	public int closeItem(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			st.executeUpdate("UPDATE sportequipmentshop.item SET is_open = false WHERE id = '" + id + "'");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Connection error");
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Statement error");
			}
		}
		return id;
	}*/

	/*@Override
	public int openItem(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			st.executeUpdate("UPDATE sportequipmentshop.item SET is_open = true WHERE id = '" + id + "'");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Connection error");
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Statement error");
			}
		}
		return id;
	}*/

	public int deleteItem(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectorDB.getConnection();
			ps = con.prepareStatement("DELETE FROM sportequipmentshop.item WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Connection error");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Statement error");
			}
		}
		return id;
	}

	public List<Item> getAllItems() throws DAOException {
		Connection con = null;
		Statement st = null;
		List<Item> list = new ArrayList<Item>();
		try {
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			ResultSet rs = null;
			try {
				rs = st.executeQuery(
						"SELECT sportequipmentshop.item.id, equipment_id, user_id, quantity, user.login, "
						+ "user.password, equipment.name, equipment.price, equipment.cost "
						+ "FROM sportequipmentshop.item "
						+ "JOIN sportequipmentshop.equipment ON sportequipmentshop.item.equipment_id = equipment.id "
						+ "JOIN sportequipmentshop.user ON sportequipmentshop.item.user_id = user.id");
				while (rs.next()) {
					int id = rs.getInt(1);
					int eq_id = rs.getInt(2);
					int user_id = rs.getInt(3);
					int quantity = rs.getInt(4);
					String login = rs.getString(5);
					String pas = rs.getString(6);
					String eq_name = rs.getString(7);
					double eq_price = rs.getDouble(8);
					double eq_cost = rs.getDouble(9);
					list.add(new Item(id, quantity, new Equipment(eq_id, eq_name, eq_cost, eq_price), new User(user_id, login, pas)));
				}
			} finally {
				if (rs != null) {
					rs.close();
				} else {
					System.err.println("Reading error");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Connection error");
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.print("Statement error");
			}
		}
		return list;
	}

	@Override
	public List<Item> getItemsByUserId(int u_id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> list = new ArrayList<Item>();
		try {
			con = ConnectorDB.getConnection();
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(
						"SELECT sportequipmentshop.item.id, equipment_id, user_id, quantity, user.login, "
						+ "user.password, equipment.name, equipment.price, equipment.cost "
						+ "FROM sportequipmentshop.item "
						+ "JOIN sportequipmentshop.equipment ON sportequipmentshop.item.equipment_id = equipment.id "
						+ "JOIN sportequipmentshop.user ON sportequipmentshop.item.user_id = user.id "
						+ "WHERE sportequipmentshop.item.user_id = ?");
				ps.setInt(1, u_id);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					int eq_id = rs.getInt(2);
					int user_id = rs.getInt(3);
					int quantity = rs.getInt(4);
					String login = rs.getString(5);
					String pas = rs.getString(6);
					String eq_name = rs.getString(7);
					double eq_price = rs.getDouble(8);
					double eq_cost = rs.getDouble(9);
					list.add(new Item(id, quantity, new Equipment(eq_id, eq_name, eq_cost, eq_price), new User(user_id, login, pas)));
				}
			} finally {
				if (rs != null) {
					rs.close();
				} else {
					System.err.println("Reading error");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.println("Connection error");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				System.err.print("Statement error");
			}
		}
		return list;
	}


}
