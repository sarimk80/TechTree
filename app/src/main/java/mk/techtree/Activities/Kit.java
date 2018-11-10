package mk.techtree.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mk.techtree.MainActivity;
import mk.techtree.R;
import spencerstudios.com.bungeelib.Bungee;

public class Kit extends AppCompatActivity {

    @BindView(R.id.OverViewtext)
    TextView overtext;

    @BindView(R.id.back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit);
        ButterKnife.bind(this);
        overtext.setText("Kit");
    }

    @OnClick(R.id.back)
    public void backClick(){
        Intent intent=new Intent(Kit.this, MainActivity.class);
        startActivity(intent);
        Bungee.slideDown(Kit.this);
    }
}
