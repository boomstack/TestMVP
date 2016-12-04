package com.boomstack.testmvp.view;

import com.boomstack.testmvp.base.BaseView;
import com.boomstack.testmvp.model.InfoModel;
import com.boomstack.testmvp.presenter.IMainPresenter;

/**
 * Created by wangkangfei on 2016/12/4.
 */

public interface IMainView extends BaseView<IMainPresenter>{
    void showErrorMsg(String str);
    void showNetResult(InfoModel model);
}
