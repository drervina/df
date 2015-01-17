package ir.drervina.dontforget;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.TimePickerDialog;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;


public class Nia extends ActionBarActivity {
    private Button btnSetTime,btnSetDate,btnPushToDb;
    private EditText edtTitle,edtDesc;
    private CheckBox chkMarked;
    private Boolean marked;
    private int umin,uhour,uyear,umonth,uday;
    private int current_day, current_month, current_year ,current_min ,current_hour;
    DbClass db = new DbClass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nia);


        btnSetTime =(Button)findViewById(R.id.btnSetTime);
        btnPushToDb =(Button)findViewById(R.id.btnPushToDb);
        btnSetDate =(Button)findViewById(R.id.btnSetDate);
        edtTitle =(EditText)findViewById(R.id.edtTitle);
        edtDesc =(EditText)findViewById(R.id.edtDesc);
        chkMarked =(CheckBox)findViewById(R.id.chkMarked);
        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ShowMyTimePickerDialog();
            }
        });
        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMyDatePickerDialog();
            }
        });
        btnPushToDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mh1 = String.valueOf(umin);
                String mh2 = String.valueOf(uhour);
                String mh3 = mh2+mh1;
                int AL1 =Integer.parseInt(mh3);
                String ymd1 = String.valueOf(uyear);
                String ymd2 = String.valueOf(umonth);
                String ymd3 = String.valueOf(uday);
                String ymd4 = ymd1 +ymd2+ymd3;
                int AL2 =Integer.parseInt(ymd4);

                String edtT,edtD;
                edtT= edtTitle.getText().toString();
                edtD= edtDesc.getText().toString();
                if (chkMarked.isChecked()) {
                    marked = true;
                }else{
                        marked = false;
                }
                db.addEntry(null,AL1,AL2,edtT,edtD,"Tag place",1234,"subject",1);


            }
        });


    }

    public void ShowMyTimePickerDialog() {
        final Calendar c = Calendar.getInstance();
        current_hour = c.get(Calendar.HOUR_OF_DAY);
        current_min = c.get(Calendar.MINUTE);
        TimePickerDialog.OnTimeSetListener timelistener = new TimePickerDialog.OnTimeSetListener() {


            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(Nia.this,"Time set > " + hourOfDay +" : " + minute,Toast.LENGTH_SHORT).show();
                umin = minute;
                uhour=hourOfDay;
            }

        };

        TimePickerDialog tpd1 = new TimePickerDialog(Nia.this, timelistener, current_hour, current_min, true);
        tpd1.show();
    }
    public void ShowMyDatePickerDialog(){
        final Calendar c = Calendar.getInstance();
        current_day =c.get(Calendar.DAY_OF_MONTH);
        current_year =c.get(Calendar.YEAR);
        current_month =c.get(Calendar.MONTH);

        DatePickerDialog dpd1 = new DatePickerDialog(Nia.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(Nia.this,"Date set >" + year +"/"+(monthOfYear+1)+"/"+dayOfMonth,Toast.LENGTH_SHORT).show();
                uyear=year;
                umonth=monthOfYear+1;
                uday=dayOfMonth;
            }
        }, current_year, current_month, current_day);
        dpd1.show();

    }
}
