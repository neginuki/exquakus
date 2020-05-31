package world.sake.exquakus.member;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import world.sake.exquakus.doma.dao.MemberDao;
import world.sake.exquakus.doma.entity.Member;

@Path("/members")
public class MemberController {

    private final MemberDao memberDao;

    public MemberController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    // e.g. http://localhost:8081/members/
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> get() {
        return memberDao.selectList();
    }

    // e.g. http://localhost:8081/members/1
    @GET
    @Path("/{memberId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Member get(@PathParam Long memberId) {
        return memberDao.selectById(memberId);
    }
}
