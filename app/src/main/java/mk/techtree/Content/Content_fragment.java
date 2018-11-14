package mk.techtree.Content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import mk.techtree.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content_fragment extends Fragment {


    TextView paragraph;
    TextView code;
    ImageView imageView;

    public Content_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_content_fragment, container, false);
        Content_activity content_activity = (Content_activity) getActivity();

        paragraph = view.findViewById(R.id.paragraph);
        code = view.findViewById(R.id.code);
        imageView = view.findViewById(R.id.image);


        String Description = content_activity.getDescription();
        String Code = content_activity.Send_Code();
        String Image = content_activity.Send_Image();

        Picasso.get().load(Image).into(imageView);


        Description = Description.replace("\\n", System.getProperty("line.separator"));
        Code = Code.replace("\\n", System.getProperty("line.separator"));
        Code = Code.replace("\\t", "       ");

        paragraph.setText(Description);
        code.setText(Code);

        return view;
    }

}
