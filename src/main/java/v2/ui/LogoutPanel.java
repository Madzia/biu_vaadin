package v2.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class LogoutPanel  implements View  {

	public LogoutPanel() {
        UI.getCurrent().setContent(new LoginPanel());
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
