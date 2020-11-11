package com.com.tasks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.com.tasks.Model.ModelDB;
import com.com.tasks.R;

import java.util.ArrayList;

public class Recycler_Tasks extends RecyclerView.Adapter<Recycler_Tasks.mRTasks> {
    Context mContext ;
    ArrayList<ModelDB> mList;
    Onclick onclick ;

    public Recycler_Tasks(Context mContext, ArrayList<ModelDB> mList ,Onclick onclick) {
        this.mContext = mContext;
        this.onclick =onclick  ;
        if (mList!=null)
        this.mList = mList;
        else this.mList = new ArrayList<>();
    }

    public Recycler_Tasks(View.OnClickListener onClickListener, ArrayList<ModelDB> mList) {
    }

    @NonNull
    @Override
    public mRTasks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.item_recycler,parent,false);
        mRTasks mRTasks=new mRTasks(view);
        return mRTasks;
    }

    @Override
    public void onBindViewHolder(@NonNull final mRTasks holder, final int position) {

        holder.texttask.setText(mList.get(position).getTasks_text());
      //  holder.chack.setChecked(mList.get(position).isCheck() );
        holder.chack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.chack.isChecked())
                {
                    onclick.onitemcheack(true);
                }
                else
                {
                    onclick.onitemcheack(false);
                }

            }
        });


        /*holder.chack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    onclick.onitemcheack(true);
                }
                else
                {
                    onclick.onitemcheack(false);
                }


            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void insertItems(ArrayList<ModelDB> getallData) {
        this.mList.clear();
        this.mList.addAll(getallData);
        notifyDataSetChanged();
    }

    public class mRTasks extends RecyclerView.ViewHolder{
        TextView id_cont ,texttask;
        CheckBox chack ;
        public mRTasks(@NonNull View itemView) {
            super(itemView);
            texttask=itemView.findViewById(R.id.task_text);
            chack=itemView.findViewById(R.id.checkbox);
        }


    }

    public interface Onclick
    {
      boolean onitemcheack(boolean i);
    }

}
