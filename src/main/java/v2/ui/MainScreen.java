package v2.ui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class MainScreen extends CustomComponent {

    MenuLayout root = new MenuLayout();
    ComponentContainer viewDisplay = root.getContentContainer();
    CssLayout menu = new CssLayout();
    CssLayout menuItemsLayout = new CssLayout();
    {
        menu.setId("testMenu");
    }
    private Navigator navigator;
    private final LinkedHashMap<String, String> menuItems = new LinkedHashMap<String, String>();

    public MainScreen() {
       
    	menu.setWidth("320px");
    	menu.setHeight("100%");
        root.setWidth("100%");

        root.addMenu(buildMenu());

        navigator = new Navigator(UI.getCurrent(), viewDisplay);


//[TODO]
//        navigator.addView("signout", LogoutPanel.class);
        navigator.addView("chat", ChatPanel.class);

        final String f = UI.getCurrent().getPage().getUriFragment();
        if (f == null || f.equals("") || f.contains("!chat")) {
            navigator.navigateTo("chat");
        }

        navigator.setErrorView(ChatPanel.class);

        navigator.addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(final ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(final ViewChangeEvent event) {
                for (final Iterator<Component> it = menuItemsLayout.iterator(); it
                        .hasNext();) {
                    it.next().removeStyleName("selected");
                }
                for (final Entry<String, String> item : menuItems.entrySet()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (final Iterator<Component> it = menuItemsLayout
                                .iterator(); it.hasNext();) {
                            final Component c = it.next();
                            if (c.getCaption() != null
                                    && c.getCaption().startsWith(
                                            item.getValue())) {
                                c.addStyleName("selected");
                                break;
                            }
                        }
                        break;
                    }
                }
                menu.removeStyleName("valo-menu-visible");
            }
        });
        setCompositionRoot(root);
    }
        
    
    //method was from [https://vaadin.com/valo#design] and changed
    CssLayout buildMenu() {
       	// Add items
       	menuItems.put("signout", "Sign out");
       	menuItems.put("chat", "Chat");
       	final HorizontalLayout top = new HorizontalLayout();
       	top.setWidth("100%");
       	top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
       	top.addStyleName("valo-menu-title");
       	menu.addComponent(top);
       	final Button showMenu = new Button("Menu", new ClickListener() {
	       	@Override
	       	public void buttonClick(final ClickEvent event) {
	        	if (menu.getStyleName().contains("valo-menu-visible")) {
	        		menu.removeStyleName("valo-menu-visible");
	        	} else {
	        		menu.addStyleName("valo-menu-visible");
	        	}
	       	}
       	});
       	showMenu.addStyleName("valo-menu-toggle");
       	showMenu.setIcon(FontAwesome.LIST);
       	menu.addComponent(showMenu);
       	final Label title = new Label( 
       			"<h3>Vaadin <strong>Chat</strong></h3>", ContentMode.HTML);
       	title.setSizeUndefined();
       	top.addComponent(title);
       	top.setExpandRatio(title, 1);
       	final MenuBar settings = new MenuBar();
       	settings.addStyleName("user-menu");
       	menuItemsLayout.setPrimaryStyleName("valo-menuitems");
       	menu.addComponent(menuItemsLayout);
       	for (final Entry<String, String> item : menuItems.entrySet()) {
	        	final Button b = new Button(item.getValue(), new ClickListener() {
	        	@Override
	        	public void buttonClick(final ClickEvent event) {
	        		navigator.navigateTo(item.getKey());
	        	}
	       	});
	       	b.setHtmlContentAllowed(true);
	       	b.setPrimaryStyleName("valo-menu-item");
	       	//b.setIcon(testIcon.get());
	       	menuItemsLayout.addComponent(b);
	    }
       	return menu;
    }
}
