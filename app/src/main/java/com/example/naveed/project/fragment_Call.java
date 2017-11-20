package com.example.naveed.project;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;


/**
 * Created by Naveed on 10/16/2017.
 */

public class fragment_Call extends Fragment {

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_layout, container, false);

        Cursor mCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null,
                null, null);
        int number = mCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int date = mCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = mCursor.getColumnIndex(CallLog.Calls.DURATION);
        int type = mCursor.getColumnIndex(CallLog.Calls.TYPE);
        StringBuilder sb = new StringBuilder();
        while (mCursor.moveToNext()) {
            String phnumber = mCursor.getString(number);
            String callduration = mCursor.getString(duration);
            String calltype = mCursor.getString(type);
            String calldate = mCursor.getString(date);
            Date d = new Date(Long.valueOf(calldate));
            String callTypeStr = "";
            switch (Integer.parseInt(calltype)) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callTypeStr = "Outgoing";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callTypeStr = "Incoming";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callTypeStr = "Missed";
                    break;
            }
            sb.append("Phone number " + phnumber);
            sb.append(System.getProperty("line.separator"));
            sb.append("Call duration " + callduration);
            sb.append(System.getProperty("line.separator"));
            sb.append("Call type " + callTypeStr);
            sb.append(System.getProperty("line.separator"));
            sb.append("Call date " + d);
            sb.append("---------------------------");
            sb.append(System.getProperty("line.separator"));
        }

        TextView callDetails = (TextView) view.findViewById(R.id.callLog);
        callDetails.setText(sb.toString());



        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getMenuInflater().inflate(R.menu.fragment_Call, menu);
        return true;
    }
}
