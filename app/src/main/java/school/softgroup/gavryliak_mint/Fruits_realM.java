package school.softgroup.gavryliak_mint;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by GMisha on 06.02.2017.
 */

public class Fruits_realM extends RealmObject {
    @PrimaryKey
    private String id;
    @Required
    private String fruit_name;

    public String getFruit_name() {
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
