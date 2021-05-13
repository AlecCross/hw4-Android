package com.example.a4android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tvText = findViewById(R.id.TextMessage);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private  void myDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


//      AlertDialog dialog = builder.create();
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.my_dialog, null);

        builder.setTitle(R.string.dialog_title);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog alertDialog = (AlertDialog) dialog;
                EditText editText = alertDialog.findViewById(R.id.edText);
                if (editText != null) {
                    assert editText !=null;
                    tvText.setText(editText.getText().toString());
                }
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setView(cl);

        builder.show();
    }

    public void editMenuClick(MenuItem item) {
        myDialog();
    }
}