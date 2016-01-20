package com.ahmadrosid.belajarrealm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ahmadrosid.belajarrealm.R;
import com.ahmadrosid.belajarrealm.helper.RealmHelper;
import com.ahmadrosid.belajarrealm.models.DataModel;

import java.util.ArrayList;

/**
 * Created by ocittwo on 1/19/16.
 */
public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {

    private int position;
    private Button delete, save;
    private EditText inputTitle, inputDescription;
    private RealmHelper helper;
    private String title, description;
    private String intentTitle, intentDescription;
    private ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        helper = new RealmHelper(this);
        data = new ArrayList<>();
        position = getIntent().getIntExtra("id", 0);
        intentTitle = getIntent().getStringExtra("title");
        intentDescription = getIntent().getStringExtra("description");

        delete = (Button) findViewById(R.id.delete);
        save = (Button) findViewById(R.id.save);

        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDescription = (EditText) findViewById(R.id.inputDescription);

        inputTitle.setText(intentTitle);
        inputDescription.setText(intentDescription);

        delete.setVisibility(View.VISIBLE);
        delete.setOnClickListener(this);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                save();
                break;
            case R.id.delete:
                delete();
                break;
        }
    }

    /**
     * delete data
     */
    private void delete() {
        helper.deleteData(position);
        inputTitle.setText("");
        inputDescription.setText("");
    }

    /**
     * save data
     */
    private void save() {
        title = inputTitle.getText().toString();
        description = inputDescription.getText().toString();
        helper.updateArticle(position, title, description);
        inputTitle.setText("");
        inputDescription.setText("");
    }

}