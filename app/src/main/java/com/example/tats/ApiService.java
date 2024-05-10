package com.example.tats;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v2/list")
    Call<List<Image>> getImages(@Query("page") int page, @Query("limit") int limit);
}
