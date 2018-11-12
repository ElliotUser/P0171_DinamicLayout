package robot.mr.p0171_dinamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout llMain;
    RadioGroup rbGravity;
    EditText etName;
    Button bthCreate;
    Button bthClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rbGravity = (RadioGroup) findViewById(R.id.rbGravity);
        etName = (EditText)findViewById(R.id.etName);

        bthClear = (Button)findViewById(R.id.bthClear);
        bthCreate = (Button) findViewById(R.id.bthCreate);

        bthCreate.setOnClickListener(this);
        bthClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bthCreate:
                LinearLayout.LayoutParams lParams =
                        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                int bthGravity = Gravity.LEFT;

                switch(rbGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        bthGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        bthGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        bthGravity = Gravity.RIGHT;
                        break;
                }

                lParams.gravity = bthGravity;

                Button bthNew = new Button(this);
                bthNew.setText(etName.getText().toString());
                llMain.addView(bthNew,lParams);

                break;
            case R.id.bthClear:
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
