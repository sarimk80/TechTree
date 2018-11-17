package mk.techtree.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wooplr.spotlight.SpotlightView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mk.techtree.MainActivity;
import mk.techtree.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kit extends Fragment {

    @BindView(R.id.back)
    ImageView back;

    @BindView(R.id.textview)
    TextView textView;

    public Kit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kit, container, false);

        ButterKnife.bind(this, view);
        back.setVisibility(View.VISIBLE);
        textView.setText("Kit");


        return view;
    }

    @OnClick(R.id.back)
    public void back(){
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

}
