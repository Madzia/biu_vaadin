package v2.ui;

import static com.vaadin.server.Sizeable.Unit.PIXELS;

import javax.servlet.annotation.WebServlet;

import v2.listeners.LoginClickListener;
import v2.push.BroadCastListener;
import v2.push.BroadCaster;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.ui.UI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import v2.listeners.LoginClickListener;
import com.vaadin.ui.*;

//[TODO]
//import v2.ValoThemeSessionInitListener;


import v2.push.BroadCaster;
import v2.ui.MyVaadinUI;

import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

//@Theme("valo")
@SuppressWarnings("serial")
@Title("Vaadin Workshop")
@PreserveOnRefresh
@Push
@Theme("mytheme")
public class MyVaadinUI extends UI implements BroadCastListener<Object> {

//
//    @WebServlet(value = "/*", asyncSupported = true)
//    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
//    public static class Servlet extends VaadinServlet {
//
////[TODO]
////        @Override
////        protected void servletInitialized() throws ServletException {
////            super.servletInitialized();
////            getService().addSessionInitListener(
////                    new ValoThemeSessionInitListener());
////        }
//    }
    @Override
    protected void init(VaadinRequest request) {
        CssLayout root = new CssLayout();
        Button button = new Button("Join");
        root.addComponent(new Label("Please enter credentials"));
        TextField loginField = new TextField("Name:");
        loginField.setWidth(250, PIXELS);
        root.addComponent(loginField);
        root.addComponent(button);
        button.addClickListener(new LoginClickListener(loginField));
        BroadCaster.register((BroadCastListener<?>) this);
        setContent(root);
    }

    public void onMessage(Object object) {
        access(() -> setContent(new LoginPanel()));
    }

    @Override
    public void detach() {
        BroadCaster.unregister((BroadCastListener<?>) this);
        super.detach();
    }
}