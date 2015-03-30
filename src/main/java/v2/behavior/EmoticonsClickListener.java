package v2.behavior;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class EmoticonsClickListener implements Button.ClickListener {

	private TextArea input;
	FontAwesome lock;

	public EmoticonsClickListener(TextArea input, FontAwesome lock) {
        this.input = input;
        this.lock = lock;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonClick(ClickEvent event) {
		input.setValue(input.getValue() + " <"+lock.toString()+"> ");
		//input.setValue(input.getValue() + lock.toString());
	}

}
