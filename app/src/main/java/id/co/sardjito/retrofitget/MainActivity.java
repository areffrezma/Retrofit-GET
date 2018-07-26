package id.co.sardjito.retrofitget;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.co.sardjito.retrofitget.apis.ApiClient;
import id.co.sardjito.retrofitget.apis.ApiService;
import id.co.sardjito.retrofitget.models.Profile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezma on 25/07/2018.
 * Insti Sardjito
 * instisardjito@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    //variabel instance
    private Button getData;
    private TextView id;
    private TextView name;
    private TextView job;
    private TextView age;
    private EditText number;
    private String numID;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable local
        getData = (Button) findViewById(R.id.getprofile);
        number = (EditText) findViewById(R.id.edNumber);
        id = (TextView) findViewById(R.id.idprofile);
        name = (TextView) findViewById(R.id.nameprofile);
        job = (TextView) findViewById(R.id.jobprofile);
        age = (TextView) findViewById(R.id.ageprofile);

        String numID = number.getText().toString();

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Get Retrofit Profile");
                progressDialog.setMessage("Please Wait..");
                progressDialog.show();

                getProfile();
            }
        });
    }

    private void getProfile() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<Profile> call = apiService.getMyProfile(numID);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                progressDialog.dismiss();
                Profile p = response.body();

                id.setText(p.getId());
                name.setText(p.getName());
                job.setText(p.getJob());
                age.setText(p.getAge());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Failed to Load", Toast.LENGTH_LONG).show();
            }
        });
    }
}
