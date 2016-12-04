package com.boomstack.testmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.boomstack.testmvp.R;
import com.boomstack.testmvp.model.InfoModel;
import com.boomstack.testmvp.presenter.IMainPresenter;
import com.boomstack.testmvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    private IMainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化presenter
        mPresenter = new MainPresenter(this);
        mPresenter.getInfoFromNet(1);
    }

    @Override
    public void showErrorMsg(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetResult(InfoModel model) {
        Toast.makeText(this, model.result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(IMainPresenter iMainPresenter) {
        this.mPresenter = iMainPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //presenter回收
        if (mPresenter != null) {
            mPresenter.destroy();
        }
    }
}
