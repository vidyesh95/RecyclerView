package com.righttickk.recyclerview;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        AppBarLayout mAppBarLayout = findViewById(R.id.header_container);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                } else if (isShow) {
                    isShow = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        int flags = getWindow().getDecorView().getSystemUiVisibility(); // get current flag
                        flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; // use XOR here for remove LIGHT_STATUS_BAR from flags
                        getWindow().getDecorView().setSystemUiVisibility(flags);
                    }
                }
            }
        });

        ArrayList<RecyclerViewItem> recyclerViewList = new ArrayList<>();
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_one,
                "Amazon Basic Dustbin \n for the CHEAP People",
                "₹50", "Amazon.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_two,
                "Trumps Favorite Dustbin",
                "₹2,662", "orange.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_three,
                "Green Resolution Eco Dustbin" +
                        "-Save Nature",
                "₹1,199", "greenify.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_four,
                "Louis Vuitton Designer Dustbin",
                "₹50,000", "louisvuitton.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_one, "Line 9", "Line 10", "Amazon.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_two, "Line 11", "Line 12", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_three, "Line 13", "Line 14", "Alibaba.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_four, "Line 15", "Line 16", "Aliexpress.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_one, "Line 17", "Line 18", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_two, "Line 19", "Line 20", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_three, "Line 21", "Line 22", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_four, "Line 23", "Line 24", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_one, "Line 25", "Line 26", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_two, "Line 27", "Line 28", "Bajaao.com"));
        recyclerViewList.add(new RecyclerViewItem(R.drawable.item_three, "Line 29", "Line 30", "Bajaao.com"));

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,2);
        mAdapter = new RecyclerViewAdapter(recyclerViewList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = getWindow().getDecorView().getSystemUiVisibility(); // get current flag
            if (flags==View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) {
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; // use XOR here for remove LIGHT_STATUS_BAR from flags
                getWindow().getDecorView().setSystemUiVisibility(flags);
            }
        }
    }
}
