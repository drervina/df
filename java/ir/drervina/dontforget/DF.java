package ir.drervina.dontforget;


public class DF {

    int adf_id;
    int adf_time;
    int adf_date;
    String adf_title;
    String adf_desc;
    String adf_other;
    int adf_next;
    String adf_subject;
    int adf_marked;


    public DF(){

    }

    public DF(
            int df_id,
            int df_time,
            int df_date,
            String df_title,
            String df_desc,
            String df_other,
            int df_next,
            String df_subject
          ,int df_marked ){
        this.adf_date=df_date;
        this.adf_desc=df_desc;
        this.adf_time=df_time;
        this.adf_other=df_other;
        this.adf_title=df_title;
        this.adf_next=df_next;
        this.adf_subject=df_subject;
        this.adf_marked=df_marked;

    }

    public void setAdf_marked(int adf_marked) {
        this.adf_marked = adf_marked;
    }

    public void setAdf_subject(String adf_subject) {

        this.adf_subject = adf_subject;
    }

    public void setAdf_next(int adf_next) {

        this.adf_next = adf_next;
    }

    public int getAdf_marked() {

        return adf_marked;
    }

    public String getAdf_subject() {

        return adf_subject;
    }

    public int getAdf_next() {

        return adf_next;
    }


    public void setAdf_other(String adf_other) {
        this.adf_other = adf_other;
    }

    public void setAdf_desc(String adf_desc) {

        this.adf_desc = adf_desc;
    }

    public void setAdf_title(String adf_title) {

        this.adf_title = adf_title;
    }

    public void setAdf_date(int adf_date) {

        this.adf_date = adf_date;
    }

    public void setAdf_time(int adf_time) {

        this.adf_time = adf_time;
    }

    public void setAdf_id(int adf_id) {

        this.adf_id = adf_id;
    }

    public String getAdf_desc() {

        return adf_desc;
    }

    public String getAdf_title() {

        return adf_title;
    }

    public int getAdf_date() {

        return adf_date;
    }

    public int getAdf_time() {

        return adf_time;
    }

    public int getAdf_id() {

        return adf_id;
    }

    public String getAdf_other() {

        return adf_other;
    }




}
