package world.sake.exquakus.doma.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import world.sake.exquakus.doma.DbConfigAware;
import world.sake.exquakus.doma.entity.Brand;

@Dao
@DbConfigAware
public interface BrandDao {

    @Select
    Brand selectById(Long breweryId, Long brandId);

    @Select
    List<Brand> selectByBreweryId(Long breweryId);
}
