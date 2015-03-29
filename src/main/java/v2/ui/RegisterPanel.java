package v2.ui;


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
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class RegisterPanel extends VerticalLayout implements View  {
	//String login;
	//String password;
	//Integer passwordTest;
	//String mail;
	
	//TODO
	//private TestIcon testIcon = new TestIcon(140);

	public RegisterPanel(){
        setMargin(true);
        addStyleName("content-common");

        Label h1 = new Label("Register");
        h1.addStyleName("h1");
        addComponent(h1);

        VerticalLayout row = new VerticalLayout();
        row.setWidth("100%");
        row.setSpacing(true);
        addComponent(row);

        row.addComponent(init());
	}
	
	Panel init(){

		//TODO
		//left.setMargin(new MarginInfo(false, true, false, false));
		Panel p = new Panel("Register Account");
        final VerticalLayout content = new VerticalLayout();
        p.setContent(content);
        content.setSpacing(true);
        content.setMargin(true);
        
		TextField value = new TextField("Login");
		value.setInputPrompt("Login");
		value.addStyleName("color1");
		content.addComponent(value);

		value = new TextField("password");
		value.setInputPrompt("Secret words");
		//TODO
		//value.setIcon(FontAwesome.LOCK);
		value.addStyleName("inline-icon");
		content.addComponent(value);

		value = new TextField("rewrite password");
		value.setInputPrompt("Rewrite password");
		value.addStyleName("color1");
		content.addComponent(value);

		value = new TextField("Email");
		value.setInputPrompt("Email");
		value.addStyleName("inline-icon");
		//TODO
		//value.setIcon(testIcon.get());
		content.addComponent(value);

		Button value_btn = new Button("Register");
		// button.addStyleName("primary");
		content.addComponent(value_btn);

		value_btn = new Button("Cancel");
		// button.addStyleName("primary");
		content.addComponent(value_btn);
        return p;
	}
@Override
	public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	}
}
