

public class TbContent {



    private int sl;
    private String PID;
    private String Pname;
    private String Cname;
    private String Dname;
    private String Etype;
    private String WId;
    private String Edate;
    private String Ay;

    public TbContent(int sl,String PID, String pname, String cname, String dname, String etype, String WId, String edate, String ay) {
        this.PID = PID;
        this.sl = sl;
        Pname = pname;
        Cname = cname;
        Dname = dname;
        Etype = etype;
        this.WId = WId;
        Edate = edate;
        Ay = ay;
    }

    public TbContent() {
    }

    public int getSl() {
        return sl;
    }
    
    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getEtype() {
        return Etype;
    }

    public void setEtype(String etype) {
        Etype = etype;
    }

    public String getWId() {
        return WId;
    }

    public void setWId(String WId) {
        this.WId = WId;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public String getAy() {
        return Ay;
    }

    public void setAy(String ay) {
        Ay = ay;
    }

    public static void setSl(int sl) {
        sl = sl;
    }



}
