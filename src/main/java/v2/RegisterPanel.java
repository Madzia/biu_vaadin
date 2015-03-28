package v2;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.server.FontAwesome;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RegisterPanel extends VerticalLayout implements View  {
	//String login;
	//String password;
	//Integer passwordTest;
	//String mail;
	
	//TODO
	//private TestIcon testIcon = new TestIcon(140);

	public RegisterPanel(){}
	
	public Component init(VerticalLayout left){

		//TODO
		//left.setMargin(new MarginInfo(false, true, false, false));

		TextField value = new TextField("Login");
		value.setInputPrompt("Login");
		value.addStyleName("color1");
		left.addComponent(value);

		value = new TextField("password");
		value.setInputPrompt("Secret words");
		//TODO
		//value.setIcon(FontAwesome.LOCK);
		value.addStyleName("inline-icon");
		left.addComponent(value);

		value = new TextField("rewrite password");
		value.setInputPrompt("Rewrite password");
		value.addStyleName("color1");
		left.addComponent(value);

		value = new TextField("Email");
		value.setInputPrompt("Email");
		value.addStyleName("inline-icon");
		//TODO
		//value.setIcon(testIcon.get());
		left.addComponent(value);

		Button value_btn = new Button("Register");
		// button.addStyleName("primary");
		left.addComponent(value_btn);

		value_btn = new Button("Cancel");
		// button.addStyleName("primary");
		left.addComponent(value_btn);
		return left;


	}
@Override
	public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	}
}
