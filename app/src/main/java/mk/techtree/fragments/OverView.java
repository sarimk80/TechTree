package mk.techtree.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mk.techtree.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverView extends Fragment {


    public OverView() {
        // Required empty public constructor
    }

    @BindView(R.id.raspberry)
    ImageView raspberry;

    @BindView(R.id.kit)
    ImageView kit;

    @BindView(R.id.textview)
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_over_view, container, false);
        ButterKnife.bind(this, view);

        textView.setText("OverView");


        return view;
    }

    @OnClick(R.id.raspberry)
    public void rasp() {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder,new RaspberryPi());
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();

    }


    @OnClick(R.id.kit)
    public void kit() {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder,new mk.techtree.fragments.Kit());
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();

    }





}
