package v2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
//@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)//, widgetset = "v2.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }
	
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        RegisterPanel aaa = new RegisterPanel();
        setContent( aaa.init(layout) );
        
        Button button = new Button("register");
        button.addStyleName("quiet");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
            	
            }
        });
	layout.addComponent(button);
        /*Button[9] button;
	Label wynik = new Label("?");
	for (int i=0; i<9; i++)
	
		button[i] = new Button(i);
        	button[i].addClickListener(new Button.ClickListener() {
            	public void buttonClick(ClickEvent event) {
                	//layout.addComponent(new Button(i));
			wynik.text = i;
		}
        	});
        	layout.addComponent(button[i]);
	}	
        layout.addComponent(wynik);*/
    }

}
