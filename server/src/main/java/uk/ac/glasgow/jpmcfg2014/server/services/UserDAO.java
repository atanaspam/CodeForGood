package uk.ac.glasgow.jpmcfg2014.server.services;

import java.util.List;

import javax.sql.DataSource;

import uk.ac.glasgow.jpmcfg2014.server.domain.User;

public interface UserDAO {

	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the User table.
	 * @return 
	 */
	public User create(String name);

	/**
	 * This is the method to be used to list down a record from the User
	 * table corresponding to a passed student id.
	 */
	public User get(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * User table.
	 */
	public List<User> listUsers();

	/**
	 * This is the method to be used to delete a record from the User table
	 * corresponding to a passed user id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the User table.
	 */
	public void update(Integer id, String name);

}
