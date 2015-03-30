package v2.behavior;

import v2.ui.MainScreen;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

@SuppressWarnings("serial")
public class LoginClickListener implements Button.ClickListener {

    private TextField loginField;

    public LoginClickListener(TextField loginField) {
        this.loginField = loginField;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        VaadinSession.getCurrent().setAttribute(String.class, loginField.getValue());
        UI.getCurrent().setContent(new MainScreen());
        Notification.show("You've been successfully join in");
    }
}
