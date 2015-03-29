package v2.listeners;

//import ch.frankel.vaadin.workshop.ui.MainScreen;

import v2.ui.LoggedInPanel;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class LoginClickListener implements Button.ClickListener {

    private TextField loginField;

    public LoginClickListener(TextField loginField) {
        this.loginField = loginField;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        VaadinSession.getCurrent().setAttribute(String.class, loginField.getValue());
        UI.getCurrent().setContent((Component) new LoggedInPanel());
        Notification.show("You've been successfully join in");
    }
}
