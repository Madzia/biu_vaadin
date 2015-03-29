package v2.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginPanel extends VerticalLayout implements View  {
	//String login;
	//String password;
	//Integer passwordTest;
	//String mail;
	
	//TODO
	//private TestIcon testIcon = new TestIcon(140);

	public LoginPanel() {
        setMargin(true);
        addStyleName("content-common");

        Label h1 = new Label("Sign in");
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
		Panel p = new Panel("Sign in");
        final VerticalLayout content = new VerticalLayout();
        p.setContent(content);
        content.setSpacing(true);
        content.setMargin(true);
        
        HorizontalLayout wrap2 = new HorizontalLayout();
        wrap2.addStyleName("wrapping");
        wrap2.setSpacing(true);
        content.addComponent(wrap2);
        
		TextField value = new TextField("Email");
		value.setInputPrompt("Email");
		value.addStyleName("inline-icon");
		wrap2.addComponent(value);
		
		value = new TextField("password");
		value.setInputPrompt("Secret words");
		//TODO
		//value.setIcon(FontAwesome.LOCK);
		value.addStyleName("inline-icon");
		wrap2.addComponent(value);

		HorizontalLayout wrap = new HorizontalLayout();
        wrap.addStyleName("wrapping");
        wrap.setSpacing(true);
        content.addComponent(wrap);
        
		Button value_btn = new Button("Sign in");
		// button.addStyleName("primary");
		wrap.addComponent(value_btn);

		value_btn = new Button("Cancel");
		// button.addStyleName("primary");
		wrap.addComponent(value_btn);

		value_btn = new Button("Register");
		// button.addStyleName("primary");
		content.addComponent(value_btn);
        return p;
	}
@Override
	public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	}
}
