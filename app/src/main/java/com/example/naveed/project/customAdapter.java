package com.example.naveed.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Naveed on 10/20/2017.
 */

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {

//    private ImageView ivPic;
//    private TextView tvName;
//    private TextView tvDate;
//    private ImageView ivStatus;


    private Context mContext;
    private LayoutInflater inflater;
    private List<ModelCall> mListCall;

    private static final String incoming = "INCOMING";
    private static final String outgoing = "OUTGOING";
    private static final String missed = "MISSED";

    public customAdapter(Context mContext, List<ModelCall> modelCallList) {
        this.mContext = mContext;
        mListCall = modelCallList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPic;
        TextView tvName;
        TextView tvDate;
        ImageView ivStatus;

        public ViewHolder(View itemView) {

            super(itemView);
            ivPic = itemView.findViewById(R.id.display);
            ivStatus = itemView.findViewById(R.id.call_status);
            tvName = itemView.findViewById(R.id.name);
            tvDate = itemView.findViewById(R.id.time);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {

        inflater = LayoutInflater.from(mContext);
        // Inflate the custom layout
        final View contactView = inflater.inflate(R.layout.fragment_layout_call, viewGroup, false);

        // Return a new holder instance
        final ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        ImageView ivPic;
        TextView tvName;
        TextView tvDate;
        ImageView ivStatus;


        viewHolder.ivPic.setImageResource(R.drawable.images);
        viewHolder.tvName.setText(mListCall.get(i).getName());
        viewHolder.tvDate.setText(mListCall.get(i).getDate() + "");
//        tvName = viewHolder.tvName;
//        tvName.setText(mListCall.get(i).getName() + "");
//        tvDate = viewHolder.tvDate;
//        tvDate.setText(mListCall.get(i).getDate() + "");
//        ivStatus= viewHolder.ivStatus;
//        ivStatus.setText(mListCall.get(i).getStatus() + "");

//        if(ivStatus.equals(incoming)){
//            ivStatus.setImageResource(R.drawable.ic_call_received_black_24dp);
//        }
//        if(ivStatus.equals(missed)){
//            ivStatus.setImageResource(R.drawable.ic_call_missed_black_24dp);
//        }
//        if(ivStatus.equals(outgoing)){
//            ivStatus.setImageResource(R.drawable.ic_call_made_black_24dp);
//        }


    }

    @Override
    public int getItemCount() {
        return mListCall.size();

    }

}
