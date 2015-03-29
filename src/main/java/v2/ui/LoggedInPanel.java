package v2.ui;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.ui.Table.ColumnHeaderMode.HIDDEN;

public class LoggedInPanel {

	@SuppressWarnings("serial")
	public class MainScreen extends CustomComponent {

	    public MainScreen() {
	       Panel panel = new Panel("Welcome " + VaadinSession.getCurrent().getAttribute(String.class));
	        panel.setSizeFull();
	        HorizontalLayout menuBar = new HorizontalLayout();
	        menuBar.addStyleName("wrapping");
	        TextArea messageArea = new TextArea();
	        messageArea.setWidth(95, PERCENTAGE);
	        Button sendButton = new Button("Send");
	        HorizontalLayout lowerBar = new HorizontalLayout(messageArea, sendButton);
	        lowerBar.setWidth(95, PERCENTAGE);
	        lowerBar.setSpacing(true);
	        VerticalLayout mainLayout = new VerticalLayout(menuBar, lowerBar);
	        mainLayout.setWidth(90, PERCENTAGE);
	        mainLayout.setWidth(90, PERCENTAGE);
	        mainLayout.addStyleName("wrapping");
	        mainLayout.setSpacing(true);
	        mainLayout.setMargin(true);
	        //mainLayout.setSizeFull();
	        panel.setContent(mainLayout);
	        setCompositionRoot(panel);
	    }
	}

}
