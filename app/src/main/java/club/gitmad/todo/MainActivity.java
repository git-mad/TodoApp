package club.gitmad.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnInputListener {
    private RecyclerView mainScreenTaskNameList;
    private ArrayList<String> taskNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainScreenTaskNameList = findViewById(R.id.task_name_list);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem() {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(), "CustomDialog");
    }

    @Override
    public void sendInput(String input) {
        taskNames.add(input);
        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
        mainScreenTaskNameList.getAdapter().notifyItemInserted(taskNames.size());
    }

}
