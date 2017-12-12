package com.example.naveed.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Naveed on 10/16/2017.
 */

public class fragment_Call extends Fragment {

    private RecyclerView recyclerView;
    //TextView callDetails;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_layout, container, false);

        //callDetails = (TextView) view.findViewById(R.id.callLog);

        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        requestPermission();
//    }
//
//    public StringBuilder getCallLogs()
//    {
//        // reading all data in descending order according to DATE
//
//        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
//        Uri callUri = Uri.parse("content://call_log/calls");
//        Cursor mCursor = getActivity().getContentResolver().query(callUri, null, null, null, strOrder);
//
//
//        // loop through cursor
//
//        int number = mCursor.getColumnIndex(CallLog.Calls.NUMBER);
//        int date = mCursor.getColumnIndex(CallLog.Calls.DATE);
//        int duration = mCursor.getColumnIndex(CallLog.Calls.DURATION);
//        int type = mCursor.getColumnIndex(CallLog.Calls.TYPE);
//
//
//        StringBuilder sb = new StringBuilder();
//        while (mCursor.moveToNext()) {
//            String phnumber = mCursor.getString(number);
//            String callduration = mCursor.getString(duration);
//            String calltype = mCursor.getString(type);
//            String calldate = mCursor.getString(date);
//            Date d = new Date(Long.valueOf(calldate));
//            String callTypeStr = "";
//            switch (Integer.parseInt(calltype)) {
//                case CallLog.Calls.OUTGOING_TYPE:
//                    callTypeStr = "Outgoing";
//                    break;
//                case CallLog.Calls.INCOMING_TYPE:
//                    callTypeStr = "Incoming";
//                    break;
//                case CallLog.Calls.MISSED_TYPE:
//                    callTypeStr = "Missed";
//                    break;
//            }
//            sb.append("Phone number " + phnumber);
//            sb.append(System.getProperty("line.separator"));
//            sb.append("Call duration " + callduration);
//            sb.append(System.getProperty("line.separator"));
//            sb.append("Call type " + callTypeStr);
//            sb.append(System.getProperty("line.separator"));
//            sb.append("Call date " + d);
//            sb.append("---------------------------");
//            sb.append(System.getProperty("line.separator"));
//        }
//        return sb;
//
//    }
//    public void requestPermission() {
//
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_CALL_LOG)) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
//                dialog.setTitle("Your Permission Required");
//                dialog.setMessage("Some decoding needs respective of your calls ");
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//                    }
//                });
//                dialog.setNegativeButton("Do not Want", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(),"User is King!",Toast.LENGTH_LONG).show();
//                    }
//                });
//                dialog.show();
//
//
//            } else {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//            }
//        }
//        else
//        {
//            callDetails.setText(getCallLogs().toString());
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode==1)
//        {
//            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
//            {
//                getCallLogs();
//            }
//            else if(grantResults[0]==PackageManager.PERMISSION_DENIED)
//            {
//                callDetails.setText("Permission Index 0");
//            }
//        }
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//
//    }
}