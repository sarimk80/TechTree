package mk.techtree.Content;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mk.techtree.Activities.Raspberrypi;
import mk.techtree.MainActivity;
import mk.techtree.R;
import spencerstudios.com.bungeelib.Bungee;

public class Content_activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */


    private ViewPager mViewPager;

    @BindView(R.id.heading)
    TextView textView;

    @BindView(R.id.back)
    ImageView imageView;

    String Description;

    String Code;

    String Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        ButterKnife.bind(this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        SetupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(mViewPager);

        String Title = getIntent().getStringExtra("Title");

        Description = getIntent().getStringExtra("Description");

        Code = getIntent().getStringExtra("Code");

        Image=getIntent().getStringExtra("Image");


        textView.setText(Title);


    }

    public String getDescription() {
        return Description;
    }

    public String Send_Code() {
        return Code;
    }

    public String Send_Image(){
        return Image;
    }


    private void SetupViewPager(ViewPager viewPager) {

        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.AddFragments(new Content_fragment(), "Content");
        sectionPageAdapter.AddFragments(new Youtube_fragment(), "Youtube");

        viewPager.setAdapter(sectionPageAdapter);


    }


}
