package huit.fit.transferdata2fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnFragmentManager{

    FrameLayout frameFragment;
    Button btnMoFrag2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameFragment=(FrameLayout) findViewById(R.id.framFragment);
        btnMoFrag2=(Button)findViewById(R.id.btnMoFrg2);
        addEvent();

        loadFragment(new FragmentA());
        //-------------
//        FragmentManager fm = getSupportFragmentManager();
//        Bundle bundle=new Bundle();
//        fm.setFragmentResult("myData",bundle);
//        int t=bundle.getInt("OpenFrag");
//        Toast.makeText(this,String.valueOf(t),Toast.LENGTH_LONG).show();
//        if(t==2)
//            loadFragment(new FragmentB());
        //--------------------------

    }
    void addEvent()
    {
        btnMoFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentB());
            }
        });
    }

    public void loadFragment (Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.framFragment,fragment);
        ft.commit();
    }

    @Override
    public void onOpenFragment(int frag) {

    }
}