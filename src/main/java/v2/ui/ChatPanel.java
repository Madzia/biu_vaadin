package v2.ui;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import java.util.Collection;
import java.util.Iterator;
import v2.behavior.EmoticonsClickListener;
import v2.behavior.SendMessageClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.PopupView.Content;

@SuppressWarnings("serial")
public class ChatPanel extends HorizontalLayout implements View{
	public ChatPanel() {
        setMargin(true);
        addStyleName("content-common");

        VerticalLayout row = new VerticalLayout();
        row.setWidth("100%");
        row.setSpacing(true);
        addComponent(row);

        row.addComponent(init());
	}
	
	Panel init(){
		Panel p = new Panel("Welcome in chat");
        
        HorizontalLayout menuBar = new HorizontalLayout();
        menuBar.addStyleName("wrapping");
        menuBar.setSpacing(true);
        
        MessageTable table = new MessageTable();
        TextArea messageArea = new TextArea();
        messageArea.setWidth("30em");
        
        Panel p2 = new Panel("Chat");
        p2.addStyleName("scroll-divider");
        p2.setContent(panelContentScroll());
        p2.setHeight("17em");
        p2.setWidth("45em");
        addComponent(p2);
        VerticalLayout right = new VerticalLayout();
        right.setSpacing(true);
        right.setMargin(true);
        p2.setContent(right);
        FromTableToLabel(table, right);
        Button sendButton = new Button("Send");
        sendButton.addClickListener(new SendMessageClickListener(table, right, messageArea));

        CssLayout menu = new CssLayout();
        
        VerticalLayout icons = InitEmoticons(messageArea);
        
        PopupView pv = new PopupView(new Content() {
        	@Override
	        public Component getPopupComponent() {
		        return new VerticalLayout() {
		        	{
				        setMargin(true);
				        setWidth("300px");
				        addStyleName("color1");
				        addComponent(icons);
				        }
		        };
	        }
	        @Override
	        public String getMinimizedValueAsHTML() {
	        	return "Emoticons";
	        }
        });
        menu.addComponent(pv);
        HorizontalLayout lowerBar = new HorizontalLayout(messageArea, menu, sendButton);
        lowerBar.setWidth(95, PERCENTAGE);
        lowerBar.setSpacing(true);
        
        VerticalLayout mainLayout = new VerticalLayout(menuBar, p2, lowerBar);
        mainLayout.setWidth(90, PERCENTAGE);
        mainLayout.setWidth(90, PERCENTAGE);
        mainLayout.addStyleName("wrapping");
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        p.setContent(mainLayout);
        return p;
	}

	private void FromTableToLabel(MessageTable table, VerticalLayout vl) {
		Collection<?> list = table.getItemIds();
		Iterator<?> itr = list.iterator();
		Label val;
		String str;
		String[] splited_str;
		StringBuffer checking;
		
		StringBuffer buf;
	      while(itr.hasNext()) {
	  		str = table.getItem(itr.next()).toString();
	  		str = checking_string_emoticons(str);
	  		splited_str = str.split("\\|");
	  		buf =  new StringBuffer(splited_str[3].subSequence(7, splited_str[3].length()));
	  		checking = new StringBuffer(splited_str[4].subSequence(11, splited_str[4].length()));
	  		if (checking.equals("null")) buf.append(":");
	  		else buf.append("@"+splited_str[4].subSequence(11, splited_str[4].length())+":");
	  		buf.append(splited_str[2].subSequence(5, splited_str[2].length()));
	  		val = new Label(buf.toString());
	  		val.setContentMode(ContentMode.HTML);
	        vl.addComponent(val);
	      }
	}

	private String checking_string_emoticons(String str) {
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

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	private VerticalLayout InitEmoticons(TextArea messageArea){
		VerticalLayout icons = new VerticalLayout();
		HorizontalLayout icons1 = new HorizontalLayout();
		HorizontalLayout icons2 = new HorizontalLayout();
		icons.addComponent(icons1);
		icons.addComponent(icons2);
	    Button button = new Button("");
	    FontAwesome add_icon = FontAwesome.LOCK;
	    button.setIcon(add_icon);
	    button.addStyleName("borderless-colored");
	    button.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons1.addComponent(button);
	    Button button2 = new Button("");
	    add_icon = FontAwesome.ANDROID;
	    button2.setIcon(add_icon);
	    button2.addStyleName("borderless-colored");
	    button2.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons1.addComponent(button2);
	    Button button3 = new Button("");
	    add_icon = FontAwesome.APPLE;
	    button3.setIcon(add_icon);
	    button3.addStyleName("borderless-colored");
	    button3.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons1.addComponent(button3);
	    Button button4 = new Button("");
	    add_icon = FontAwesome.ARROW_LEFT;
	    button4.setIcon(add_icon);
	    button4.addStyleName("borderless-colored");
	    button4.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons2.addComponent(button4);
	    Button button5 = new Button("");
	    add_icon = FontAwesome.BUG;
	    button5.setIcon(add_icon);
	    button5.addStyleName("borderless-colored");
	    button5.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons2.addComponent(button5);
	    Button button6 = new Button("");
	    add_icon = FontAwesome.GLOBE;
	    button6.setIcon(add_icon);
	    button6.addStyleName("borderless-colored");
	    button6.addClickListener(new EmoticonsClickListener(messageArea, add_icon));
	    icons2.addComponent(button6);
	    
	    return icons;
	}
	Component panelContentScroll() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		Label content = new Label();
		content.setWidth("10em");
		layout.addComponent(content);
		Button button = new Button("Button");
		layout.addComponent(button);
		return layout;
		}
}
