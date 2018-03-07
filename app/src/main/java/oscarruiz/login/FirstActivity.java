package oscarruiz.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {


    Button btnlogin , btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        btnlogin = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignup);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(FirstActivity.this, LoginActivity.class);
//                startActivity(i);

                presentActivity(view);
            }
        });

    }
    public void presentActivity(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(LoginActivity.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}



