package v2.behavior;

import java.util.Collection;
import java.util.Iterator;

import v2.data.Person;
import v2.ui.MainScreen;
import v2.ui.UsersTable;

import com.vaadin.data.Item;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class SignInUserListener implements Button.ClickListener {

    private UsersTable users;
    private TextField login;
    private PasswordField pw;
    

    public SignInUserListener(UsersTable users, TextField login, PasswordField pw) {
        this.users = users;
        this.login = login;
        this.pw = pw;
    }
	@Override
	public void buttonClick(Button.ClickEvent event) {
		// TODO Auto-generated method stub
		String pws = pw.getValue();
		String logins = login.getValue();
		boolean val = false;
		if (pws.length() < 5 || logins.length() < 7)
		{
	        Notification.show("To short data.");
		}
		else 
		{
			Collection<?> ids = users.getItemIds();
			Iterator itr = ids.iterator();
			while(itr.hasNext()) {
				Item now_checking = users.getItem(itr.next());
				if (logins.equals(now_checking.getItemProperty("LOGIN").getValue()))
				{
					if (pws.equals(now_checking.getItemProperty("PASSWORD").getValue()))
					{
						VaadinSession.getCurrent().setAttribute(String.class, logins);
				        UI.getCurrent().setContent(new MainScreen());
				        Notification.show("You've been successfully join in");
				        return;
					}
					else {
				        Notification.show("Bad password.");
				        return;
			        }
				}
			}
	        Notification.show("User doesn't exists in our database.");
		}
	}

}
