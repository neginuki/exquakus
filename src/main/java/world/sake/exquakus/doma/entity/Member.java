package world.sake.exquakus.doma.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Member {

    @Id
    public Long memberId;

    public String memberName;

    public String email;

    public String password;

    public String statusCode;

    public Long versionNo;

    public Integer displayOrder;

    public LocalDateTime registerDatetime;

    public String registerTrace;

    public LocalDateTime updateDatetime;

    public String updateTrace;

    public Member() {
    }

    public Member(Long memberId, String memberName, String email, String password, String statusCode, Long versionNo, Integer displayOrder,
            LocalDateTime registerDatetime, String registerTrace, LocalDateTime updateDatetime, String updateTrace) {
        super();
        this.memberId = memberId;
        this.memberName = memberName;
        this.email = email;
        this.password = password;
        this.statusCode = statusCode;
        this.versionNo = versionNo;
        this.displayOrder = displayOrder;
        this.registerDatetime = registerDatetime;
        this.registerTrace = registerTrace;
        this.updateDatetime = updateDatetime;
        this.updateTrace = updateTrace;
    }
}
