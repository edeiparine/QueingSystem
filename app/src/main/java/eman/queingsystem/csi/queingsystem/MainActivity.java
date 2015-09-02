package eman.queingsystem.csi.queingsystem;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eman.queingsystem.csi.queingsystem.data.DataHandler;


public class MainActivity extends ActionBarActivity {

    Button save, load;
    EditText name, email;
    TextView addTextView;

    DataHandler handler;

    Spinner spinner;

    final int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {

        save = (Button) findViewById(R.id.saveButton);
        load = (Button) findViewById(R.id.loadButton);
        name = (EditText) findViewById(R.id.nameEditBox);
        email = (EditText) findViewById(R.id.emailEditBox);


        addTextView = (TextView) findViewById(R.id.addTextView);


        final List addUser = new ArrayList();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser.add(count);
                String getName = name.getText().toString();
                String getEmail = email.getText().toString();
                handler = new DataHandler(getBaseContext());
                handler.open();

                long id = handler.insertData(getName, getEmail);
                Toast.makeText(getBaseContext(), "Name: " + getName + "\n" + "E-mail: " + getEmail, Toast.LENGTH_SHORT).show();
                addTextView.setText("Your Queue Number is: " + addUser.size());
                handler.close();

                clearFields();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName, getEmail;
                getName = "";
                getEmail = "";

                handler = new DataHandler(getBaseContext());
                handler.open();

                Cursor cursor = handler.returnData();
                if (cursor.moveToFirst()) {
                    do {
                        getName = cursor.getString(0);
                        getEmail = cursor.getString(1);
                    } while (cursor.moveToNext());
                }
                handler.close();
                Toast.makeText(getBaseContext(), "Name: " + getName + "\n" + "E-mail: " + getEmail, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        name.setText("");
        email.setText("");
    }
}
