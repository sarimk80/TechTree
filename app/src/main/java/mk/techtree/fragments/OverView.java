package mk.techtree.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mk.techtree.Activities.Kit;
import mk.techtree.Activities.Raspberrypi;
import mk.techtree.R;
import spencerstudios.com.bungeelib.Bungee;

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
        Intent intent = new Intent(getActivity(), Raspberrypi.class);
        startActivity(intent);
        Bungee.slideUp(getActivity());
    }


    @OnClick(R.id.kit)
    public void kit() {
        Intent intent = new Intent(getActivity(), Kit.class);
        startActivity(intent);
        Bungee.slideUp(getActivity());
    }

}
