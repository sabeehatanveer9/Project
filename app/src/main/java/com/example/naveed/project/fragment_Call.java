package com.example.naveed.project;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Naveed on 10/16/2017.
 */

public class fragment_Call extends Fragment {

    private static final String TAG1 = "MYTAG";
    private RecyclerView recyclerView;
    //TextView callDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_layout, container, false);

        //callDetails = (TextView) view.findViewById(R.id.callLog);
        recyclerView = view.findViewById(R.id.recycler_view);
        customAdapter cAdapter = new customAdapter(getContext(), getCallLogs());
        recyclerView.setAdapter(cAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

    public List<ModelCall> getCallLogs() {
        List<ModelCall> list = new ArrayList<>();
        // reading all data in descending order according to DATE
//
//        String strOrder = CallLog.Calls.DATE + " ASC";
//
//        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//        }
//        Cursor mCursor = getActivity().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, strOrder);
//
//
//        // loop through cursor
//
//        int name = mCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
//        int date = mCursor.getColumnIndex(CallLog.Calls.DATE);
//        int duration = mCursor.getColumnIndex(CallLog.Calls.DURATION);
//        int type = mCursor.getColumnIndex(CallLog.Calls.TYPE);
//
//
//        mCursor.moveToFirst();
//        while (mCursor.moveToNext()) {
//            list.add(new ModelCall(mCursor.getString(name), mCursor.getString(date), mCursor.getString(type)));
//
//        }
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALL_LOG}, 1);

        }
        Cursor cursor = getActivity().getContentResolver().query(
                android.provider.CallLog.Calls.CONTENT_URI, null, null, null,
                android.provider.CallLog.Calls.DATE + " DESC ");
//        Log.d(TAG1, "getCallLogs: "+ list.get(0).getName());


        int numberColumnId = cursor.getColumnIndex(android.provider.CallLog.Calls.NUMBER);
        int durationId = cursor.getColumnIndex(android.provider.CallLog.Calls.DURATION);
        int contactNameId = cursor.getColumnIndex(android.provider.CallLog.Calls.CACHED_NAME);
        int dateId = cursor.getColumnIndex(android.provider.CallLog.Calls.DATE);
        int numTypeId = cursor.getColumnIndex(android.provider.CallLog.Calls.CACHED_NUMBER_TYPE);

        Date dt = new Date();
        int hours = dt.getHours();
        int minutes = dt.getMinutes();
        int seconds = dt.getSeconds();
        String currTime = hours + ":" + minutes + ":" + seconds;

        ArrayList<String> callList = new ArrayList<String>();
        if (cursor.moveToFirst()) {

            do {


                String contactNumber = cursor.getString(numberColumnId);
                String contactName = cursor.getString(contactNameId);
                String duration = cursor.getString(durationId);
                String callDate = DateFormat.getDateInstance().format(dateId);

                String numType = cursor.getString(numTypeId);

                list.add(new ModelCall(contactName,callDate));

            } while (cursor.moveToNext());


        }
        return list;
    }
}