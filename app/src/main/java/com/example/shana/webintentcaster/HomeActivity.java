package com.example.shana.webintentcaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        startActivityWithSelectedItem(spinner.getSelectedItem().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.actions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivityWithSelectedItem(item.getTitle().toString());
        return true;
    }

    private void startActivityWithSelectedItem(String selectedItem){
        try{
            startActivity(IntentFactory.getIntent(selectedItem, editText.getText().toString()));
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
