package id.co.sardjito.retrofitget.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rezma on 25/07/2018.
 * Insti Sardjito
 * instisardjito@gmail.com
 */

public class ApiClient {
    public static final String BASE_URL = "http://private-fc41f-myprofile2.apiary-mock.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
