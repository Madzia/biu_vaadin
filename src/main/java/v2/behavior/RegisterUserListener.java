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
import com.vaadin.ui.UI;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class RegisterUserListener implements Button.ClickListener {

    private UsersTable users;
    private TextField login;
    private TextField email;
    private PasswordField pw1;
    private PasswordField pw2;
    

    public RegisterUserListener(UsersTable users, TextField login, TextField email, PasswordField pw1,PasswordField pw2) {
        this.users = users;
        this.login = login;
        this.email = email;
        this.pw1 = pw1;
        this.pw2 = pw2;
    }
	@Override
	public void buttonClick(Button.ClickEvent event) {
		// TODO Auto-generated method stub
		String pw1s = pw1.getValue();
		String pw2s = pw2.getValue();
		String emails = email.getValue();
		String logins = login.getValue();
		if ((!pw1s.equals(pw2s)) || pw1s.length() < 5 || emails.length() < 7)
		{
	        Notification.show("Passwords are different or to short data.");
		}
		else 
		{
			Collection<?> ids = users.getItemIds();
			Iterator<?> itr = ids.iterator();
			while(itr.hasNext()) {
				Item now_checking = users.getItem(itr.next());
				if (emails.equals(now_checking.getItemProperty("EMAIL").getValue()))
				{
			        Notification.show("Mail address already is in our database.");
			        return;
				}
				if (logins.equals(now_checking.getItemProperty("LOGIN").getValue()))
				{
			        Notification.show("Login address already is in our database.");
			        return;
				}
			}
			Person person = new Person(logins, emails, pw1s);
			users.addUser(person);
	        VaadinSession.getCurrent().setAttribute(String.class, logins);
	        UI.getCurrent().setContent(new MainScreen());
	        Notification.show("You've been successfully join in");
		}
	}

}
