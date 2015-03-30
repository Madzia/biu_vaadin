package v2.ui;

import v2.push.BroadCastListener;
import v2.push.BroadCaster;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import com.vaadin.annotations.Theme;

@SuppressWarnings("serial")
@Title("Vaadin Workshop")
@PreserveOnRefresh
@Push
@Theme("mytheme")
public class MyVaadinUI extends UI implements BroadCastListener<Object> {

    @Override
    protected void init(VaadinRequest request) {
    	setContent(new LoginPanel());
	    BroadCaster.register(this);
}

    @Override
    public void onMessage(Object object) {
    	 access(() -> setContent(new MainScreen()));
//        access(() -> {
//            MenuLayout root = new MenuLayout();
//            ComponentContainer viewDisplay = root.getContentContainer();
//        	Navigator navigator = new Navigator(UI.getCurrent(), viewDisplay);
//            navigator.addView("chat", ChatPanel.class);
//            navigator.navigateTo("chat");
//        });
    }

    @Override
    public void detach() {
        BroadCaster.unregister(this);
        super.detach();
    }
}
