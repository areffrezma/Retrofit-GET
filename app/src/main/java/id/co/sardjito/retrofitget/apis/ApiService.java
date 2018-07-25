package id.co.sardjito.retrofitget.apis;

import id.co.sardjito.retrofitget.models.Profile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rezma on 25/07/2018.
 * Insti Sardjito
 * instisardjito@gmail.com
 */
public interface ApiService {
    @GET("myself")
    Call<Profile> getMyProfile (@Query("id") String id);
}
