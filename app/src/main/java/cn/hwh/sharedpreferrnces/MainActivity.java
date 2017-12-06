package cn.hwh.sharedpreferrnces;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etInputData;
    private Button btnWrite;
    private Button btnRead;
    private TextView tvshowdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputData=(EditText)findViewById(R.id.et_input_data);
        btnWrite=(Button)findViewById(R.id.btn_write);
        btnRead=(Button)findViewById(R.id.btn_read);
        tvshowdata=(TextView)findViewById(R.id.tv_show_data);
        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_write:
                writeData();
                break;
            case R.id.btn_read:
                readData();
                break;
        }
    }

    private void readData() {
        SharedPreferences sp=getPreferences("file",MODE_PRIVATE);
        String strData=sp.getString("data","");
        tvshowdata.setText(strData);
    }

    private SharedPreferences getPreferences(String file, int modePrivate) {
        return null;
    }


    private void writeData() {
        String strInputData=etInputData.getText().toString();
        SharedPreferences.Editor editor=getSharedPreferences("file",MODE_PRIVATE).edit();
        editor.putString("data",strInputData);
        editor.commit();
    }
}
