package com.example.naveed.project;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class CallLogHelper {

	public static Cursor getCallLogs(ContentResolver cr)
    {
        // reading all data in descending order according to DATE

        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
        Uri callUri = Uri.parse("content://call_log/calls");
        Cursor mCursor = cr.query(callUri, null, null, null, strOrder);

        return mCursor;

    }


}
