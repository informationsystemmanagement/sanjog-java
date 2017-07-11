/**
 * 
 */
package fr.epita.sanjog.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.sanjog.datamodel.Identity;

/**
 * @author Admin
 *
 */
public class IdentityJDBC {
	private Connection currentConnection;

	

	/**
	 * Connect to the Database
	 * 
	 * @throws SQLException any SQL Error
	 */
	private Connection getConnection() throws SQLException {
		try {
			this.currentConnection.getSchema();
		} catch (Exception e) {
			String user = "sanjog";
			String password = "sanjog";
			String connectionString = "jdbc:derby://localhost:1527/sanjog;create=true";
			this.currentConnection = DriverManager.getConnection(connectionString, user, password);
		}
		return this.currentConnection;
	}


	//insert
	public void insert1(Identity identity) throws SQLException{
		Connection connection = getConnection();
		
		String insertdb = "INSERT INTO sanjog123(UNAME , UEMAIL)VALUES (?, ?)";
	     PreparedStatement prpnstm = connection.prepareStatement(insertdb);
		prpnstm.setString(1, identity.getUname());
		prpnstm.setString(2, identity.getUemail());
		prpnstm.execute();
	}
	
	
	//update
	
	public void update(Identity identity1) throws SQLException{
		
		Connection connection = getConnection();
		
		
		String insertdb = "UPDATE sanjog123 SET uemail = 'rouuu' WHERE uname = 'ii'";
	     PreparedStatement prpnstm = connection.prepareStatement(insertdb);
		//prpnstm.setString(1, identity1.getUname());
		//prpnstm.setString(2, identity1.getUemail());
		prpnstm.execute();
		connection.close();
		
		
		
	
	}
	
	
	//delete
	public void delete(Identity identity) throws SQLException {
		Connection connection = getConnection();

		String sqldelete = "DELETE FROM sanjog123 WHERE uname = ?";
		PreparedStatement prpnstmt = connection.prepareStatement(sqldelete);
		prpnstmt.setString(1, identity.getUname());
		prpnstmt.execute();
	}
	//list
	public List<Identity> readAllIdentities() throws SQLException {
		List<Identity> identities = new ArrayList<Identity>();

		Connection connection = getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from sanjog123");
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			String uname = rs.getString("UNAME");
			String uemail = rs.getString("UEMAIL");
			Identity identity = new Identity(uname, uemail);
			identities.add(identity);
		}
		return identities;
	}


}


