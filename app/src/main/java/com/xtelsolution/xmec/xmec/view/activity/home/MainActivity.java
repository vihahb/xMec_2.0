package com.xtelsolution.xmec.xmec.view.activity.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.xtelsolution.xmec.R;
import com.xtelsolution.xmec.xmec.model.entity.ItemNavigationDrawer;
import com.xtelsolution.xmec.xmec.presenter.home.HomePresenter;
import com.xtelsolution.xmec.xmec.view.activity.BasicActivity;
import com.xtelsolution.xmec.xmec.view.adapter.home.AdapterNavigationDrawer;

import java.util.ArrayList;

public class MainActivity extends BasicActivity implements HomeView {

    private ArrayList<ItemNavigationDrawer> menuArray;
    private RecyclerView rcl_navigationdrawer;
    private AdapterNavigationDrawer adapterDrawer;
    private NavigationView navigationView;
    private HomePresenter presenter;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new HomePresenter(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        initDataNavigation();
    }

    private void initDataNavigation() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuArray = new ArrayList<>();
        rcl_navigationdrawer = (RecyclerView) findViewById(R.id.recycleNavigation);
        adapterDrawer = new AdapterNavigationDrawer(menuArray, this, MainActivity.this);
        rcl_navigationdrawer.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rcl_navigationdrawer.setAdapter(adapterDrawer);
        presenter.iCmd.excute(1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setDataNavigation(ArrayList<ItemNavigationDrawer> dataNavigation) {
        if (dataNavigation.size() > 0){
            adapterDrawer.refreshData(dataNavigation);
        }
    }

    @Override
    public void itemDrawerClick(View view, int position) {
        switch (position){
            case 0:
                showShortSnackBar(view, "Click y bạ");
                break;
            case 1:
                showShortSnackBar(view, "Click tin tức");
                break;
            case 2:
                showShortSnackBar(view, "Click Tra cứu bệnh");
                break;
            case 3:
                showShortSnackBar(view, "Click tra cứu thuốc");
                break;
            case 4:
                showShortSnackBar(view, "Click cơ sở y tế");
                break;
            case 6:
                showShortSnackBar(view, "Click chia sẻ");
                break;
            case 7:
                showShortSnackBar(view, "Click cài đặt");
                break;
            case 9:
                showShortSnackBar(view, "Click đăng xuất");
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
    }
}
