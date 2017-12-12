package com.example.naveed.project;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Naveed on 10/20/2017.
 */

public class customAdapter  extends RecyclerView.Adapter<customAdapter.ViewHolder> {

    private ImageView ivPic;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivStatus;

    private ArrayList<String> conNames;
    private ArrayList<String> conNumbers;
    private ArrayList<String> conTime;
    private ArrayList<String> conDate;
    private ArrayList<String> conType;

    private Context mContext;
    private LayoutInflater inflater;

    private static final String incoming= "INCOMING";
    private static final String outgoing= "OUTGOING";
    private static final String missed= "MISSED";

    public customAdapter(Context mContext , int resource, int textViewResourceId, ArrayList<String> conNames) {

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {

            super(itemView);
            ivPic= itemView.findViewById(R.id.display);
            ivStatus= itemView.findViewById(R.id.call_status);
            tvName= itemView.findViewById(R.id.name);
            tvDate= itemView.findViewById(R.id.time);

            conNames = new ArrayList<String>();
            conNumbers = new ArrayList<String>();
            conTime = new ArrayList<String>();
            conDate = new ArrayList<String>();
            conType = new ArrayList<String>();


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {

        // Inflate the custom layout
        final View contactView = inflater.inflate(R.layout.fragment_layout_call, viewGroup, false);

        // Return a new holder instance
        final ViewHolder viewHolder = new ViewHolder(contactView);

        Cursor curLog = CallLogHelper.getAllCallLogs(getContentResolver());
        setCallLogs(curLog);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

         ivPic.setImageResource(R.drawable.dp);
         tvName.setText(conNames.get(i));
         tvDate.setText(conDate.get(i));
        if(conType.equals(incoming)){
            ivStatus.setImageResource(R.drawable.in);
        }
        if(conType.equals(missed)){
            ivStatus.setImageResource(R.drawable.miss);
        }
        if(conType.equals(outgoing)){
            ivStatus.setImageResource(R.drawable.out);
        }


    }

    private void setCallLogs(Cursor curLog) {
        while (curLog.moveToNext()) {
            String callNumber = curLog.getString(curLog
                    .getColumnIndex(android.provider.CallLog.Calls.NUMBER));
            conNumbers.add(callNumber);

            String callName = curLog
                    .getString(curLog
                            .getColumnIndex(android.provider.CallLog.Calls.CACHED_NAME));
            if (callName == null) {
                conNames.add("Unknown");
            } else
                conNames.add(callName);

            String callDate = curLog.getString(curLog
                    .getColumnIndex(android.provider.CallLog.Calls.DATE));
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd-MMM-yyyy HH:mm");
            String dateString = formatter.format(new Date(Long
                    .parseLong(callDate)));
            conDate.add(dateString);

            String callType = curLog.getString(curLog
                    .getColumnIndex(android.provider.CallLog.Calls.TYPE));
            if (callType.equals("1")) {
                conType.add("INCOMING");
            } else
                conType.add("OUTGOING");

            String duration = curLog.getString(curLog.getColumnIndex(android.provider.CallLog.Calls.DURATION));
            conTime.add(duration);

        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
