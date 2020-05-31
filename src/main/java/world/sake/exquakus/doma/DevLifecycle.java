package world.sake.exquakus.doma;

import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import world.sake.exquakus.doma.dao.ScriptDao;

public class DevLifecycle {

    private final DbConfig dbConfig;

    //private final ScriptDao scriptDao;

    public DevLifecycle(DbConfig dbConfig, ScriptDao scriptDao) {
        this.dbConfig = dbConfig;

        // インメモリなら初期化も良いのだが、そうじゃない場合どうするかを考える必要がある
        //this.scriptDao = scriptDao;
    }

    void onStart(@Observes StartupEvent event) {
        dbConfig.getSqlFileRepository().clearCache();

        //
        //scriptDao.create();                
    }
}
