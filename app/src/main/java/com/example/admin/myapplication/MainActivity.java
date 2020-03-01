package com.example.admin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    int chId = 1000;
    int chPos = -1;

    LinearLayout ll;
    String[] names = {"Tom", "Dick", "Keanu", "Harry", "Katrina", "Peter", "Julia", "Emma"};
    CheckBox[] ch;
    Button btn;
    int i;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.linearLocations);
        btn = (Button) findViewById(R.id.btn);
        ch = new CheckBox[names.length];

        for (i = 0; i < names.length; i++) {
            ch[i] = new CheckBox(this);
            ch[i].setId(chId++);
            System.out.println("CHID :: " + chId);
            System.out.println("I :: " + i);
            ch[i].setText(names[i]);
            ll.addView(ch[i]);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("Inside Button", "Inside Burron" + ll.getChildCount());

                for (int i = 0; i < ll.getChildCount(); i++) {
                    View nextChild = ll.getChildAt(i);

                    if (nextChild instanceof CheckBox) {
                        CheckBox check = (CheckBox) nextChild;
                        if (check.isChecked()) {
                            //   AllCheckbox.add(check.getText().toString());
                            System.out.println("Test" + check.getId());
                        }
                    }
                }
            }
        });
    }
}