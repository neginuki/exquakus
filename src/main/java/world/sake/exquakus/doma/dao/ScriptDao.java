package world.sake.exquakus.doma.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Script;

import world.sake.exquakus.doma.DbConfigAware;

@Dao
@DbConfigAware
public interface ScriptDao {

  @Script
  void create();
}
