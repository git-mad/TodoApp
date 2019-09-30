package club.gitmad.todo;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class mListAdapter extends RecyclerView.Adapter<mListAdapter.ViewHolder> {

    private ArrayList<String> mTaskNames = new ArrayList<>();
    private Context mContext;

    public mListAdapter(ArrayList<String> taskNames, Context context) {
        mTaskNames = taskNames;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //must inflate layout for each item to create our view holder

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //add our elements to viewholder
    }

    @Override
    public int getItemCount() {
        return mTaskNames.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView taskName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.task_name);
            parentLayout = itemView.findViewById(R.id.taskItemLayout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }
}