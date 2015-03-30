package v2.ui;

import v2.behavior.RegisterUserListener;
import v2.behavior.SignInUserListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginPanel extends VerticalLayout implements View  {

	public LoginPanel() {
		UsersTable ut = new UsersTable();
        setMargin(true);
        addStyleName("content-common");

        Label h1 = new Label("Sign in or Register");
        h1.addStyleName("h1");
        addComponent(h1);

        HorizontalLayout hor = new HorizontalLayout();
        hor.setWidth("100%");
        hor.setSpacing(true);
        
        
        VerticalLayout row = new VerticalLayout();
        row.setWidth("80%");
        row.setSpacing(true);
        hor.addComponent(row);
        
        row.addComponent(initLogin(ut));
        
        VerticalLayout row2 = new VerticalLayout();
        row2.setWidth("80%");
        row2.setSpacing(true);
        hor.addComponent(row2);
        row2.addComponent(initRegister(ut));
        addComponent(hor);
	}
	
	Panel initLogin(UsersTable ut){
		Panel p = new Panel("Sign in");
        final VerticalLayout content = new VerticalLayout();
        p.setContent(content);
        content.setSpacing(true);
        content.setMargin(true);
        
        HorizontalLayout wrap2 = new HorizontalLayout();
        wrap2.addStyleName("wrapping");
        wrap2.setSpacing(true);
        content.addComponent(wrap2);
        
		TextField value = new TextField("Login");
		value.setInputPrompt("Login");
		value.setIcon(FontAwesome.USER);
		value.addStyleName("inline-icon");
		wrap2.addComponent(value);
		
		PasswordField value2 = new PasswordField("password");
		value2.setInputPrompt("Secret words");
		value2.setIcon(FontAwesome.LOCK);
		value2.addStyleName("inline-icon");
		wrap2.addComponent(value2);

		HorizontalLayout wrap = new HorizontalLayout();
        wrap.addStyleName("wrapping");
        wrap.setSpacing(true);
        content.addComponent(wrap);
        
		Button value_btn = new Button("Sign in");
		value_btn.addClickListener(new SignInUserListener(ut,value, value2));
		wrap.addComponent(value_btn);

		value_btn = new Button("Clean");
		value_btn.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
	            value.setValue("");
	            value2.setValue("");
			}
		});
		wrap.addComponent(value_btn);
        return p;
	}
	
	Panel initRegister(UsersTable ut){
		Panel p = new Panel("Register Account");
        final VerticalLayout content = new VerticalLayout();
        p.setContent(content);
        content.setSpacing(true);
        content.setMargin(true);

		HorizontalLayout hor = new HorizontalLayout();
		hor.addStyleName("wrapping");
        hor.setSpacing(true);
		content.addComponent(hor);
		
		TextField value0 = new TextField("Login");
		value0.setInputPrompt("Login");
		value0.setIcon(FontAwesome.USER);
		value0.addStyleName("inline-icon");
		hor.addComponent(value0);
        
		TextField value = new TextField("Email");
		value.setInputPrompt("Email");
		value.setIcon(FontAwesome.ENVELOPE);
		value.addStyleName("inline-icon");
		hor.addComponent(value);
		
		hor = new HorizontalLayout();
		hor.addStyleName("wrapping");
        hor.setSpacing(true);
		content.addComponent(hor);
		
		PasswordField value2 = new PasswordField("password");
		value2.setInputPrompt("Secret words");
		value2.setIcon(FontAwesome.LOCK);
		value2.addStyleName("inline-icon");
		hor.addComponent(value2);

		PasswordField value3 = new PasswordField("rewrite password");
		value3.setInputPrompt("Secret words");
		value3.setIcon(FontAwesome.LOCK);
		value3.addStyleName("inline-icon");
		hor.addComponent(value3);

		HorizontalLayout hor2 = new HorizontalLayout();
		hor2.addStyleName("wrapping");
        hor2.setSpacing(true);
		content.addComponent(hor2);
		
		Button value_btn = new Button("Register");
		value_btn.addClickListener(new RegisterUserListener(ut,value0, value, value2, value3));
		hor2.addComponent(value_btn);

		value_btn = new Button("Clean");
		value_btn.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
            		value0.setValue("");
                	value.setValue("");
                	value2.setValue("");
                	value3.setValue("");	
			}
		});
		hor2.addComponent(value_btn);
        return p;
	}
@Override
	public void enter(ViewChangeEvent event) {
	}
}
