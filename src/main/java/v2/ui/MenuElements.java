package v2.ui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

//import ch.frankel.vaadin.workshop.ui.MainScreen;


import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class MenuElements extends CustomComponent {

    private AbstractOrderedLayout layout;

    private boolean testMode = false;
    MenuLayout root = new MenuLayout();
    ComponentContainer viewDisplay = root.getContentContainer();
    CssLayout menu = new CssLayout();
    CssLayout menuItemsLayout = new CssLayout();
    {
        menu.setId("testMenu");
    }
    private Navigator navigator;
    private final LinkedHashMap<String, String> menuItems = new LinkedHashMap<String, String>();
	
	public MenuElements(AbstractOrderedLayout layout) {
		super(layout);
		this.layout = layout;
	    menu.setWidth("320px");
	
	    if (!testMode) {
	        Responsive.makeResponsive(this);
	    }
	
	    layout.addComponent(root);
	    root.setWidth("100%");
	
	    root.addMenu(buildMenu());
	    //addStyleName(ValoTheme.UI_WITH_MENU);
	
	    //UI.getCurrent().setContent(new MainScreen());
	    navigator = new Navigator(UI.getCurrent(), (ComponentContainer) UI.getCurrent().getContent());
	
	//[TODO]
	    navigator.addView("signin", LoginPanel.class);
	
	    final String f = Page.getCurrent().getUriFragment();
	    if (f == null || f.equals("")) {
	        navigator.navigateTo("signin");
	    }
	
	    navigator.setErrorView(LoginPanel.class);
	
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
	    //layout.addComponent(root);
	}

//method was from [https://vaadin.com/valo#design] and changed
	CssLayout buildMenu() {
	   	// Add items
	   	menuItems.put("signin", "Sign in");
	   	menuItems.put("panels", "Panels");
	   	menuItems.put("forms", "Forms");
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
	   			"<h3>Vaadin <strong>Tamagotchi</strong></h3>", ContentMode.HTML);
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