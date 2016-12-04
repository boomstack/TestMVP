package com.boomstack.testmvp.presenter;

import com.boomstack.testmvp.model.InfoModel;
import com.boomstack.testmvp.view.IMainView;

/**
 * Created by wangkangfei on 2016/12/4.
 */

public class MainPresenter implements IMainPresenter {
    IMainView mainView;

    public MainPresenter(IMainView mainView) {
        this.mainView = mainView;
        this.mainView.setPresenter(this);
    }

    @Override
    public void getInfoFromNet(int who) {
        System.out.println("hola  " + Thread.currentThread().getId());
        if (who == 1) {
            InfoModel model = new InfoModel();
            model.code = 0;
            model.msg = "success";
            model.result = "Got information from internet.";
            mainView.showNetResult(model);
        } else {
            mainView.showErrorMsg("error here.");
        }

    }

    @Override
    public void destroy() {
        //进行必要的垃圾回收
        mainView = null;
    }
}
