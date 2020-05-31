package world.sake.exquakus.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Brand {

    @Id
    public Long brandId;

    public String brandName;

    public String brandNameKana;

    public boolean pbFlg;
}
