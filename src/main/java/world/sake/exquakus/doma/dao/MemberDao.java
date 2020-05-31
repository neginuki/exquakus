package world.sake.exquakus.doma.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import world.sake.exquakus.doma.DbConfigAware;
import world.sake.exquakus.doma.entity.Member;

@Dao
@DbConfigAware
public interface MemberDao {

    @Select
    Member selectById(Long memberId);

    @Select
    List<Member> selectList();
}
