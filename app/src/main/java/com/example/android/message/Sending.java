package com.example.android.message;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Urmil on 3/5/2017.
 */

public class Sending extends Activity {
    Button b1;
    EditText e1;
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mob = e1.getText().toString();
                String msg = e2.getText().toString();
                if(mob.length()==10 && msg.length()>0)
                {
                    sendSMS(mob,msg);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"ENTER SOME MESSAGE TO SEND",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    protected void sendSMS(String mob,String msg)
    {
        try
        {
            SmsManager m = SmsManager.getDefault();
            m.sendTextMessage(mob,null,msg,null,null);
            Toast.makeText(getApplicationContext(),"SEND SUCCESSFULLY",Toast.LENGTH_LONG).show();
        }
        catch (Exception a)
        {
            Toast.makeText(getApplicationContext(),"NOT SEND ",Toast.LENGTH_LONG).show();
            a.printStackTrace();
        }
    }
}
