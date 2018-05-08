package com.example.a16022596.po4demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> taskList;
    private Context context;
    private TextView tvId;
    private TextView tvDescription;
    private TextView tvDate;




    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        taskList = objects;
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
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        // Get the TextView object
        tvId = (TextView) rowView.findViewById(R.id.textViewId);
        // Get the ImageView object
        tvDescription = (TextView) rowView.findViewById(R.id.textViewDescription);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the holiday at the same index.
        Task currentTitle = taskList.get(position);
        tvId.setText(""+currentTitle.getId());
        tvDescription.setText(currentTitle.getDescription());
        tvDate.setText(currentTitle.getDate());


        // Set the TextView to show the food

        // Return the nicely done up View to the ListView
        return rowView;
    }
    
}
