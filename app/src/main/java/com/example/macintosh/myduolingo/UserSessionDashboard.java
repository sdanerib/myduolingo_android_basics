package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.macintosh.myduolingo.ui.OnFragmentInteractionListener;
import com.example.macintosh.myduolingo.ui.fragments.Fragment1;
import com.example.macintosh.myduolingo.ui.fragments.Fragment2;
import com.example.macintosh.myduolingo.ui.fragments.Fragment3;

public class UserSessionDashboard extends AppCompatActivity implements OnFragmentInteractionListener {

    Intent navIntent;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    //private LanguageToLearnEntity languageToLearnObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session_dashboard);
//        getUserSessionInfo();
        ui();
    }

//    private void getUserSessionInfo() {
//        navIntent = getIntent();
//        //languageToLearnObj = (LanguageToLearnEntity) navIntent.getSerializableExtra("STUDIED_LANGUAGE");
//    }

    private void ui() {
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        TextView tviLangToBeLearned = findViewById(R.id.tviToolBarTitle);
        //tviLangToBeLearned.setText(languageToLearnObj.getLangName());
        tviLangToBeLearned.setText("Inglés");

        // - - DRAWER - -
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menu1:
                        changeFragment(0);
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.menu2:
                        //Toast.makeText(getApplicationContext(),"Stared Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(1);
                        return true;
                    case R.id.menu3:
                        //Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(2);
                        return true;

                    default:
                        return true;

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.language_progress_menu, menu);
        return true;
    }

    private void changeFragment(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = (Fragment) new Fragment1();
                break;
            case 1:
                fragment = (Fragment) new Fragment2();
                break;
            case 2:
                fragment = (Fragment) new Fragment3();
                break;
        }
        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment);
            fragmentTransaction.commit();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.closeSession:
                Log.d("MENU", "CLOSE SESSION");
                navIntent = new Intent(this, LoginActivity.class);
                startActivity(navIntent);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
