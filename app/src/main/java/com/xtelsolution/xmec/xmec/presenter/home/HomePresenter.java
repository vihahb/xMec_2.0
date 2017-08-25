package com.xtelsolution.xmec.xmec.presenter.home;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.sdk.callback.Icmd;
import com.xtelsolution.xmec.xmec.model.entity.ItemNavigationDrawer;
import com.xtelsolution.xmec.xmec.view.activity.home.HomeView;

import java.util.ArrayList;

/**
 * Created by vivh on 24/08/2017.
 */

public class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    public Icmd iCmd = new Icmd() {
        @Override
        public void excute(Object... params) {
            switch ((int)params[0]){
                case 1:
                    initDataNavigation();
                    break;
            }
        }
    };

    private void initDataNavigation() {
        ArrayList<ItemNavigationDrawer> navigationDrawers = new ArrayList<>();
        navigationDrawers.add(0, new ItemNavigationDrawer(R.mipmap.ic_medical_report, "Y bạ"));
        navigationDrawers.add(1, new ItemNavigationDrawer(R.mipmap.ic_news, "Tin tức"));
        navigationDrawers.add(2, new ItemNavigationDrawer(R.mipmap.ic_find, "Tra cứu bệnh"));
        navigationDrawers.add(3, new ItemNavigationDrawer(R.mipmap.ic_find_drug, "Tra cứu thuốc"));
        navigationDrawers.add(4, new ItemNavigationDrawer(R.mipmap.ic_hospital, "Tìm kiếm cơ sở y tế"));
        navigationDrawers.add(5, new ItemNavigationDrawer(-1, null, 1));
        navigationDrawers.add(6, new ItemNavigationDrawer(R.mipmap.ic_share, "Chia sẻ & tư vấn"));
        navigationDrawers.add(7, new ItemNavigationDrawer(R.mipmap.ic_setting, "Cài đặt"));
        navigationDrawers.add(8, new ItemNavigationDrawer(-1, null, 1));
        navigationDrawers.add(9, new ItemNavigationDrawer(R.mipmap.ic_logout, "Đăng xuất"));
        view.setDataNavigation(navigationDrawers);
    }

}
