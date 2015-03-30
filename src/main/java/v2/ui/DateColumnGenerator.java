package v2.ui;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.ui.Table;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DateColumnGenerator implements Table.ColumnGenerator {
	
    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        Item item = source.getItem(itemId);
        Property<Date> property = item.getItemProperty(columnId);
        Date date = property.getValue();
        if (date == null) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy'-'HH:mm:ss");
        return dateFormat.format(date);
    }
}
