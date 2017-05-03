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
import by.epam.web.dao.ConnectorDB;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.interfaces.EquipmentDAO;

public class SQLEquipmentDAO implements EquipmentDAO {
	private static Logger logger = LogManager.getLogger("logger");
	public SQLEquipmentDAO() {
	}

	@Override
	public Equipment addEquipment(Equipment e) throws DAOException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectorDB.getConnection();
			ps = connection.prepareStatement("INSERT INTO equipment (name, cost, price) VALUES(?,?,?)");
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getCost());
			ps.setDouble(3, e.getPrice());
			ps.executeUpdate();
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Connection was not established");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Statement was not created");
			}
		}
		return e;
	}

	@Override
	public Equipment deleteEquipment(Equipment e) throws DAOException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectorDB.getConnection();
			ps = connection.prepareStatement("DELETE FROM equipment WHERE name = ?");
			ps.setString(1, e.getName());
			ps.executeUpdate();
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Connection was not established");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Statement was not prepared");
			}
		}
		return e;
	}

	@Override
	public int deleteByID(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectorDB.getConnection();
			ps = connection.prepareStatement("DELETE FROM equipment WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e1) {
			throw new DAOException(e1);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Connection was not established");
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					throw new DAOException(e1);
				}
			} else {
				logger.info("Statement was not prepared");
			}

		}
		return id;
	}

	public int getEquipmentId(String name) throws DAOException {
		Connection con = null;
		Statement statement = null;
		int id = 0;
		String query = "SELECT id FROM equipment WHERE equipment.name = '" + name + "'";
		try {
			con = ConnectorDB.getConnection();
			statement = con.createStatement();
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
				if (rs.next()) {
					id = rs.getInt(1);
				}
			} finally {
				if (rs != null) {
					rs.close();
				} else {
					logger.info("Error while reading");
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Statement was not created");
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Connection was not created");
			}
		}

		return id;
	}

	public List<Equipment> getAllEquipment() throws DAOException {

		Connection con = null;
		Statement st = null;
		ArrayList<Equipment> list = new ArrayList<Equipment>();
		try {
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			ResultSet rs = null;
			try {
				rs = st.executeQuery("SELECT * FROM equipment");
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					double cost = rs.getDouble(3);
					double price = rs.getDouble(4);
					list.add(new Equipment(id, name, cost, price));
				}
			} finally {
				if (rs != null) {
					rs.close();
				} else {
					logger.info("Reading error");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Connection error");
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Statement error");
			}
		}
		return list;
	}

	@Override
	public Equipment getEquipmentById(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		Equipment equipment = null;
		String name = null;
		double cost=0.0;
		double price=0.0;
		try {
			ResultSet rs = null;
			con = ConnectorDB.getConnection();
			ps = con.prepareStatement("SELECT name, cost, price FROM equipment WHERE id = ?");
			ps.setInt(1, id);
			try {
				rs = ps.executeQuery();
				while (rs.next()){
					name = rs.getString(1);
					cost = rs.getDouble(2);
					price = rs.getDouble(3);
				}
				equipment = new Equipment (id, name, cost, price);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return equipment;
	}
}
