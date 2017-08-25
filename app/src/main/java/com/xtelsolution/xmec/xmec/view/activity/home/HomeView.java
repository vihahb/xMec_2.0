package com.xtelsolution.xmec.xmec.view.activity.home;

import android.view.View;

import com.xtelsolution.xmec.xmec.model.entity.ItemNavigationDrawer;

import java.util.ArrayList;

/**
 * Created by vivh on 24/08/2017.
 */

public interface HomeView {

    void setDataNavigation(ArrayList<ItemNavigationDrawer> dataNavigation);
    void itemDrawerClick(View view, int position);
}
