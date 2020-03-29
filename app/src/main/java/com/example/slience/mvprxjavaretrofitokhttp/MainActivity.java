package com.example.slience.mvprxjavaretrofitokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.slience.mvprxjavaretrofitokhttp.mvpbase.BaseRxRequest;
import com.example.slience.mvprxjavaretrofitokhttp.mvpbase.BasicResponseBean;
import com.example.slience.mvprxjavaretrofitokhttp.mvpbase.CallbackListener;
import com.example.slience.mvprxjavaretrofitokhttp.network.RetrofitManager;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseRxRequest.doRequest(RetrofitManager.getRequest().getCall(), new CallbackListener<BasicResponseBean>() {
                    @Override
                    public void onSuccess(BasicResponseBean data) {
                        tv.setText(data.toString());
                    }

                    @Override
                    public void onFailure(String msg) {
                        tv.setText(msg);
                    }

                    @Override
                    public void onError(String exception) {
                        tv.setText(exception);
                    }
                });

            }
        });
    }
}
