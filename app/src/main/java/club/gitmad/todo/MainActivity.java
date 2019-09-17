package club.gitmad.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnInputListener {
    private TextView mainScreenTaskName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Section 1 setting up the main screen:
        mainScreenTaskName = findViewById(R.id.task_name);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }


    //Section 2 adding the item:
    private void addItem() {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"CustomDialog");
    }


    //Section 3 receiving the data
    @Override
    public void sendInput(String input) {
        mainScreenTaskName.setText(input);
    }

}
