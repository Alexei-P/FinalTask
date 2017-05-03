package by.epam.web.dao.implementation;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.web.bean.User;
import by.epam.web.dao.ConnectorDB;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.interfaces.UserDAO;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;


public class SQLUserDAO implements UserDAO {
	private static Logger logger = LogManager.getLogger("logger");
	public ArrayList<User> list = new ArrayList<>();
	public SQLUserDAO() {
	}

	@Override
	public User signIn(String login, String password) throws DAOException {
		Connection connect = null;
		Statement statement = null;
		User user = null;
		try {
			connect = ConnectorDB.getConnection();
			try {
				statement = connect.createStatement();
				ResultSet rs = null;
				try {
					rs = statement.executeQuery("SELECT DISTINCT * FROM user WHERE login='" + login + "'");
					if (rs.next()) {
						String pass = rs.getString(3);
						String log = rs.getString(2);
						int id = rs.getInt(1);
						if (pass.equals(password)){
							statement.execute("UPDATE user SET is_logged = 1 WHERE login='" + login + "'");
							user = new User(id, log);
						}
						else
							logger.info("Wrong password!");
					} else
						logger.info("Wrong login!");

				} finally {
					if (rs != null) {
						rs.close();
					} else {
						logger.info("Error while reading from DB");
					}
				}
			} finally {
				if (statement != null) {
					statement.close();
				} else {
					logger.info("Statement was not created");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					logger.info("Connection error");
				}
			}
		}
		return user;

	}

	@Override
	public User register(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectorDB.getConnection();
			try{
				statement = connection.prepareStatement("SELECT login FROM user WHERE login = ?");
				statement.setString(1, user.getLogin());
				rs = statement.executeQuery();
				if(rs.next()){
					throw new DAOException("Record already exist");
				}
			}catch(SQLException e){
				throw new DAOException(e);
			}
			try {
				statement = connection.prepareStatement("INSERT INTO user (login, password) VALUES (?,?)");
				statement.setString(1, user.getLogin());
				statement.setString(2, user.getPassword());
				statement.executeUpdate();
			} finally {
				if (statement != null) {
					statement.close();
				} else {
					logger.info("Statement was not created");
				}
			}
		} catch (SQLException e) {
			logger.info("Connection was not created");
		}
		return user;

	}

	@Override
	public int deleteUser(int id) throws DAOException {
	
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectorDB.getConnection();
			statement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Connection was not created");
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			} else {
				logger.info("Statement was not created");
			}
		}
		return id;

	}
	
	public int getUserId(String login) throws DAOException {
		Connection con = null;
		Statement statement = null;
		int id = 0;
		String query = "SELECT id FROM user WHERE user.login = '"+login+"'";
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
		}
		finally {
			if (statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			else {
				logger.info("Statement was not created");
			}
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			else {
				logger.info("Connection was not created");
			}
		}

		return id;
	}

	public List<User> getAllUser() throws DAOException{
		List<User> list = new ArrayList<User>();
		Connection con = null;
		Statement st = null;
		try{
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			
			ResultSet rs = null;
			try{
				rs = st.executeQuery("SELECT * FROM user");
				while(rs.next()){
					int id = rs.getInt(1);
					String login = rs.getString(2);
					String pas = rs.getString(3);			
					list.add(new User(id, login, pas));
				}
			} finally{
				if (rs != null){
					rs.close();
				} else{
					logger.info("Reading error");
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
			else {
				logger.info("Connection error");
			}
			if (st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}else{
				logger.info("Statement error");
			}
		}
		return list;
	}

	@Override
	public String signOut(String login) throws DAOException {		
		try (Connection con = ConnectorDB.getConnection();
				Statement st = con.createStatement();){
			st.executeUpdate("UPDATE user SET is_logged = 0 WHERE login = '"+login+"'");
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return login;
	}
}
