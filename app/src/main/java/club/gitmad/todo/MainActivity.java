package club.gitmad.todo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

public class MainActivity extends AppCompatActivity implements CustomDialog.OnInputListener {
    private RecyclerView mainScreenTaskNameList;
    private ArrayList<String> taskNames = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
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
        setupList();
    }

    private void setupList() {
        layoutManager = new LinearLayoutManager(this);
        mainScreenTaskNameList.setHasFixedSize(true);
        mainScreenTaskNameList.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        mainScreenTaskNameList.addItemDecoration(itemDecor);
        FileInputStream fis1 = null;
        try {
            fis1 = this.openFileInput("myTasks.txt");
            InputStreamReader isr = new InputStreamReader(fis1);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            if(sb.toString() != "") {
                String json = sb.toString();
                Gson gson = new Gson();
                taskNames = gson.fromJson(json, new TypeToken<List<String>>(){}.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainScreenTaskNameList.setAdapter(new TaskAdapter(taskNames));

    }

    private void addItem() {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"CustomDialog");
    }



    @Override
    public void sendInput(String input) {
        taskNames.add(input);
        System.out.println(taskNames);
        String fileName = "myTasks.txt";
        Gson gson = new Gson();
        String s = gson.toJson(taskNames);
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
        setupList();
    }

}
