package world.sake.exquakus.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Brewery {

    @Id
    public Long breweryId;

    public String breweryName;

    public String breweryNameKana;

    public String address;
}
