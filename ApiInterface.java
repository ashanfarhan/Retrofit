package com.example.mediacom;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Reg.php")
    Call<User> performUserRegistration(@Query("email") String Email, @Query("username") String UserName, @Query("pass") String UserPass, @Query("firstname") String FirstName, @Query("lastname") String LastName, @Query("mobile") String Mobile, @Query("address") String Address);

    @GET("Login.php")
    Call<User> perfromUserLogin(@Query("username")String UserName,@Query("pass") String UserPass);

    @GET("Mail.php")
    Call<User> performMail(@Query("name") String Fullname,@Query("email") String Email, @Query("pass") String UserPass,@Query("message") String Message, @Query("subject") String LastName);

}
