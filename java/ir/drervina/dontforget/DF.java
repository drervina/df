package ir.drervina.dontforget;


public class DF {

    int field_id;
    int field_time;
    int field_date;
    String field_title;
    String field_desc;
    String field_other;
    int field_next;
    String field_subject;
    int field_marked;


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
        this.field_date =df_date;
        this.field_desc =df_desc;
        this.field_time =df_time;
        this.field_other =df_other;
        this.field_title =df_title;
        this.field_next =df_next;
        this.field_subject =df_subject;
        this.field_marked =df_marked;

    }

    public void setField_marked(int field_marked) {
        this.field_marked = field_marked;
    }

    public void setField_subject(String field_subject) {

        this.field_subject = field_subject;
    }

    public void setField_next(int field_next) {

        this.field_next = field_next;
    }

    public int getField_marked() {

        return field_marked;
    }

    public String getField_subject() {

        return field_subject;
    }

    public int getField_next() {

        return field_next;
    }


    public void setField_other(String field_other) {
        this.field_other = field_other;
    }

    public void setField_desc(String field_desc) {

        this.field_desc = field_desc;
    }

    public void setField_title(String field_title) {

        this.field_title = field_title;
    }

    public void setField_date(int field_date) {

        this.field_date = field_date;
    }

    public void setField_time(int field_time) {

        this.field_time = field_time;
    }

    public void setField_id(int field_id) {

        this.field_id = field_id;
    }

    public String getField_desc() {

        return field_desc;
    }

    public String getField_title() {

        return field_title;
    }

    public int getField_date() {

        return field_date;
    }

    public int getField_time() {

        return field_time;
    }

    public int getField_id() {

        return field_id;
    }

    public String getField_other() {

        return field_other;
    }




}
