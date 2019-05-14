package sg.edu.rp.c346.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sg.edu.rp.c346.demodatabase.R;
import sg.edu.rp.c346.demodatabase.Task;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> data;
    private Context context;
    private TextView tvID, tvDescription, tvDate;



    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        data = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvID = rowView.findViewById(R.id.tvID);
        // Get the ImageView object
        tvDescription = rowView.findViewById(R.id.tvDescription);
        tvDate = rowView.findViewById(R.id.tvDate);

        Task currentTask = data.get(position);

        tvID.setText(String.valueOf(currentTask.getId()));
        // Set the image to star or nostar accordingly
        tvDescription.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        return rowView;
    }
}
