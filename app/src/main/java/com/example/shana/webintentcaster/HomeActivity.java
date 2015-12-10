package com.example.shana.webintentcaster;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/9.
 */
public class HomeActivity extends AppCompatActivity {
    @Bind(R.id.activity_home_spinner)
    Spinner spinner;
    @Bind(R.id.activity_home_edit)
    EditText editText;
    @OnClick(R.id.activity_home_button)
    void onSubmit(){
        Intent intent = new Intent(spinner.getSelectedItem().toString());
        intent.putExtra(SearchManager.QUERY, editText.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.actions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }
}
