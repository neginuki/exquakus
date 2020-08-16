package world.sake.exquakus.doma.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long breweryId;

    public String breweryName;

    public String breweryNameKana;

    public String address;

    public Integer foundedYear;

    public LocalDate establishedDate;

    public LocalDate defunctDate;

    public String url;

    public String note;

    public Long displayOrder;

    public String statusCode;

    public Long versionNo;

    public String registerTrace;

    public LocalDateTime registerDatetime;

    public String updateTrace;

    public LocalDateTime updateDatetime;
}
