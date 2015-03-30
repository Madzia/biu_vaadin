package v2.behavior;

import v2.data.Message;
import v2.ui.ChatPanel;
import v2.ui.MainScreen;
import v2.ui.MessageTable;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

import java.util.Date;

@SuppressWarnings("serial")
public class SendMessageClickListener implements Button.ClickListener {

    private MessageTable output;
    private TextArea input;

    public SendMessageClickListener(MessageTable output, TextArea input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
    	int length = 75;
        String author = VaadinSession.getCurrent().getAttribute(String.class);
        String text = input.getValue();
        int begin = 0;
        int end = text.length() < length ? text.length() : length;
        StringBuffer buf_str = new StringBuffer(text.subSequence(begin, end));
        while (buf_str.length() > 1) {
        	Date date = new Date();
            Message message = new Message(author, buf_str.toString(), date);
            begin = end;
            end = text.length() < end + length ? text.length() : end + length;
            buf_str = new StringBuffer(text.subSequence(begin, end));
            output.addMessage(message);
        }
        input.setValue("");
    }
}
