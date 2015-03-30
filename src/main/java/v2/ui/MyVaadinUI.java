package v2.ui;

import v2.push.BroadCastListener;
import v2.push.BroadCaster;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.annotations.Theme;
import v2.behavior.LoginClickListener;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PIXELS;

@SuppressWarnings("serial")
@Title("Vaadin Workshop")
@PreserveOnRefresh
@Push
@Theme("mytheme")
public class MyVaadinUI extends UI implements BroadCastListener<Object> {

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
    BroadCaster.register(this);
    setContent(root);
}

    @Override
    public void onMessage(Object object) {
        access(() -> setContent(new MainScreen()));
    }

    @Override
    public void detach() {
        BroadCaster.unregister(this);
        super.detach();
    }
}
