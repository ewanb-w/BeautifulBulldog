package com.example.ewanburns_wilton.beautifuldog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;

public class BulldogActivity extends AppCompatActivity {

    private TextView nameField;
    private TextView ageField;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog);

        nameField = (TextView) findViewById(R.id.name_field);
        ageField = (TextView) findViewById(R.id.age_field);
        realm = Realm.getDefaultInstance();
        String id = (String) getIntent().getStringExtra("bulldog");
        Bulldog bulldog = realm.where(Bulldog.class).equalTo("id", id).findFirst();
        nameField.setText(bulldog.getName());
        ageField.setText(bulldog.getAge());
    }
}
