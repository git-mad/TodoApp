package club.gitmad.todo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<String> taskNames;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView taskName;
        RelativeLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.tvTaskName);
            parentLayout = itemView.findViewById(R.id.taskItemLayout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    TaskAdapter(ArrayList<String> taskNames) {
        this.taskNames = taskNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.taskName.setText(taskNames.get(position));
    }

    @Override
    public int getItemCount() {
        return taskNames.size();
    }
}