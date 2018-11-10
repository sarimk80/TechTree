package mk.techtree.Content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mk.techtree.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content_fragment extends Fragment {


    public Content_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_content_fragment, container, false);
        Content_activity content_activity=(Content_activity) getActivity();

        String Description=content_activity.getDescription();
        Log.d("Main",Description);


        return view;
    }

}
