package com.com.tasks.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.com.tasks.Adapter.Recycler_Tasks;
import com.com.tasks.Model.ModelDB;
import com.com.tasks.R;
import com.com.tasks.controlDB.ControlDB;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener, Recycler_Tasks.Onclick {
    EditText mEnterData;
    Button mDoIt, mAdd;

    RecyclerView mView;
    Recycler_Tasks mAdapter_Tasks;

    ArrayList<ModelDB> mList = new ArrayList<>();
    ControlDB mdb;

    LottieAnimationView mLo ,mLotangry;

    boolean x;

    CheckBox ch;
    Recycler_Tasks.Onclick mcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setStatusBarColor(getResources().getColor(R.color.plue));
        mdb = new ControlDB(this);

        iniview();

    }


    private void iniview() {
        mView = findViewById(R.id.Rec);
        mEnterData = findViewById(R.id.enterdata);
        mDoIt = findViewById(R.id.doit);
        mDoIt.setOnClickListener(this);
        mAdd = findViewById(R.id.add);
        mAdd.setOnClickListener(this);

         mLo = findViewById(R.id.lot);
         mLotangry=findViewById(R.id.lotangry);


        mdb = new ControlDB(this);
        mList = mdb.getallData();
        mAdapter_Tasks = new Recycler_Tasks(this, mList, this);
        mView.setAdapter(mAdapter_Tasks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home.this);
        mView.setLayoutManager(layoutManager);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                if (mEnterData.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Enter Your Task Please ", Toast.LENGTH_SHORT).show();
                } else {
                    mdb.addData(new ModelDB(mEnterData.getText().toString()));
                    mAdapter_Tasks.insertItems(mdb.getallData());
                    mEnterData.setText(" ");
                }

                break;

            case R.id.doit:
                if (onitemcheack(x)) {
                    mdb.Delete_data();
                    mLo.setVisibility(View.VISIBLE);
                    LottieAnim();

                } else {
                    mLotangry.setVisibility(View.VISIBLE);
                    lOTTieAngry();
                }
                break;

        }

    }

    private void lOTTieAngry() {
        mLotangry.setVisibility(View.VISIBLE);
        mLotangry.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mLotangry.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mLotangry.playAnimation();
    }


    private void LottieAnim() {
        mLo.setVisibility(View.VISIBLE);
        mLo.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mLo.setVisibility(View.INVISIBLE);
                finish();
                Intent intent=getIntent();
                startActivity(intent);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mLo.playAnimation();

    }


    @Override
    public boolean onitemcheack(boolean i) {

        return this.x = i;
    }

}
