package po;

import java.util.Date;

public class Light {
    private Integer lightid;

    private Integer nodeid;

    private Integer value;

    private Date date;

    public Integer getLightid() {
        return lightid;
    }

    public void setLightid(Integer lightid) {
        this.lightid = lightid;
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