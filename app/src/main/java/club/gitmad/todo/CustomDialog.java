package club.gitmad.todo;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
public class CustomDialog extends DialogFragment {
    private EditText input;
    private TextView createButton, cancelButton;
    public interface OnInputListener {
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alert_dialog_box, container, false);
        input = view.findViewById(R.id.taskNameEditText);
        createButton = view.findViewById(R.id.create_button);
        cancelButton = view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = input.getText().toString();
                mOnInputListener.sendInput(taskName);
                getDialog().dismiss();
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnInputListener= (OnInputListener) getActivity();
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }
}
