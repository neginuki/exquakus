package world.sake.exquakus.doma.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import world.sake.exquakus.doma.DbConfigAware;
import world.sake.exquakus.doma.entity.Brewery;

@Dao
@DbConfigAware
public interface BreweryDao {

    @Select
    Brewery selectById(Long breweryId);

    @Select
    List<Brewery> selectList();

    @Insert
    int insert(Brewery brewery);

    @Delete
    int delete(Brewery brewery);
}
