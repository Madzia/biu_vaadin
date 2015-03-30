package v2.behavior;

import v2.data.Message;
import v2.ui.MessageTable;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class SendMessageClickListener implements Button.ClickListener {

    private MessageTable output;
    private TextArea input;
    private VerticalLayout right;

    public SendMessageClickListener(MessageTable output, VerticalLayout right, TextArea input) {
        this.output = output;
        this.right = right;
        this.input = input;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
    	int length = 75;
    	Label label = new Label();
        String author = VaadinSession.getCurrent().getAttribute(String.class);
        String text = input.getValue();
		String str;
		Message message;
		Date date;
        int begin = 0;
        int end = text.length() < length ? text.length() : length;
        StringBuffer buf_str = new StringBuffer(text.subSequence(begin, end));
        while (buf_str.length() > 1) {
        	date = new Date();
            message = new Message(author, buf_str.toString(), date);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            str = new String(author + "@");
            str += dateFormat.format(date)+":"+buf_str.toString();
            str = checking_string_emoticons(str);
            label = new Label(str);
            label.setContentMode(ContentMode.HTML);
            right.addComponent(label);
            
            begin = end;
            end = text.length() < end + length ? text.length() : end + length;
            buf_str = new StringBuffer(text.subSequence(begin, end));
            output.addMessage(message);            
        }
        input.setValue("");
    }
    
	private String checking_string_emoticons(String str) {
		// TODO Auto-generated method stub
	    String[] icons = {"<LOCK>","<ANDROID>","<APPLE>","<ARROW_LEFT>","<BUG>","<GLOBE>"};
		while (str.contains(icons[0]))
			str = str.replace(icons[0], FontAwesome.LOCK.getHtml());		
		while (str.contains(icons[1]))
			str = str.replace(icons[1], FontAwesome.ANDROID.getHtml());		
		while (str.contains(icons[2]))
			str = str.replace(icons[2], FontAwesome.APPLE.getHtml());		
		while (str.contains(icons[3]))
			str = str.replace(icons[3], FontAwesome.ARROW_LEFT.getHtml());		
		while (str.contains(icons[4]))
			str = str.replace(icons[4], FontAwesome.BUG.getHtml());		
		while (str.contains(icons[5]))
			str = str.replace(icons[5], FontAwesome.GLOBE.getHtml());		
		return str;
	}
}
