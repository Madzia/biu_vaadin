package v2;

import java.util.LinkedHashMap;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

//[TODO]
//import v2.ValoThemeSessionInitListener;


import v2.MenuLayout;
import v2.MyVaadinUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import java.util.Iterator;
import java.util.Map.Entry;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.themes.ValoTheme;

//@Theme("valo")
@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    private boolean testMode = false;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
    public static class Servlet extends VaadinServlet {

//[TODO]
//        @Override
//        protected void servletInitialized() throws ServletException {
//            super.servletInitialized();
//            getService().addSessionInitListener(
//                    new ValoThemeSessionInitListener());
//        }
    }

    MenuLayout root = new MenuLayout();
    ComponentContainer viewDisplay = root.getContentContainer();
    CssLayout menu = new CssLayout();
    CssLayout menuItemsLayout = new CssLayout();
    {
        menu.setId("testMenu");
    }
    private Navigator navigator;
    private final LinkedHashMap<String, String> menuItems = new LinkedHashMap<String, String>();

    @Override
    protected void init(final VaadinRequest request) {
        if (request.getParameter("test") != null) {
            testMode = true;
        }

        if (getPage().getWebBrowser().isIE()
                && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
            menu.setWidth("320px");
        }

        if (!testMode) {
            Responsive.makeResponsive(this);
        }

        getPage().setTitle("Tamagotchi");
        setContent(root);
        root.setWidth("100%");

        root.addMenu(buildMenu());
        //addStyleName(ValoTheme.UI_WITH_MENU);

        navigator = new Navigator(this, viewDisplay);

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
       	showMenu.addStyleName(ValoTheme.BUTTON_PRIMARY);
       	showMenu.addStyleName(ValoTheme.BUTTON_SMALL);
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