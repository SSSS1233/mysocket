package po;

import java.util.Date;

public class Hum {
    private Integer humid;

    private Integer nodeid;

    private Integer value;

    private Date date;

    public Integer getHumid() {
        return humid;
    }

    public void setHumid(Integer humid) {
        this.humid = humid;
    }

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}