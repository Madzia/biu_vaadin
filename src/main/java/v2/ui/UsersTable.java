package v2.ui;

import v2.data.Person;

import com.vaadin.data.util.sqlcontainer.RowItem;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.QueryDelegate;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.ui.Table;

import java.sql.SQLException;

import static v2.util.Parameters.*;
import static com.vaadin.ui.Table.ColumnHeaderMode.HIDDEN;

@SuppressWarnings("serial")
public class UsersTable extends Table {
	    
	private final JDBCConnectionPool connectionPool;

	UsersTable() {
	   try {
		   connectionPool = new SimpleJDBCConnectionPool(
	                    getDatabaseDriver(),
	                    getDatabaseUrl(),
	                    getDatabaseUsername(),
	                    getDatabasePassword());
		   QueryDelegate queryDelegate = new TableQuery("PERSON", connectionPool);
		   SQLContainer container = new SQLContainer(queryDelegate);
		   container.setAutoCommit(true);
		   setContainerDataSource(container);
		   setColumnHeaderMode(HIDDEN);
		   setVisibleColumns("LOGIN", "EMAIL", "PASSWORD");
		   setSizeFull();
           setColumnWidth("TIME_STAMP", 140);
           setColumnWidth("AUTHOR", 140);
		   } catch (SQLException e) {
			   throw new RuntimeException(e);
		   }
	   }

	   public void addUser(Person person) {
		   SQLContainer container = (SQLContainer) getContainerDataSource();
		   Object rowId = container.addItem();
		   RowItem rowItem = (RowItem) container.getItem(rowId);
		   rowItem.getItemProperty("LOGIN").setValue(person.GetLogin());
		   rowItem.getItemProperty("EMAIL").setValue(person.GetMail());
		   rowItem.getItemProperty("PASSWORD").setValue(person.GetPassword());
		   }
	   
	   @Override
	   public void detach() {
		   super.detach();
		   connectionPool.destroy();
		   }
	   }
