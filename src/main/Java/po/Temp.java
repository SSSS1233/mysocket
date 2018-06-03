package po;

import java.util.Date;

public class Temp {
    private Integer tempid;

    private Integer nodeid;

    private Integer value;

    private Date date;

    public Integer getTempid() {
        return tempid;
    }

    public void setTempid(Integer tempid) {
        this.tempid = tempid;
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