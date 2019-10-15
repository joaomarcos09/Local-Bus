package br.ufc.crateus.localbus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users")
    Call<List<UserModel>> getUsers();

    @GET("/users/{email}")
    Call<UserModel> getUser(@Path("email") String email);

    @POST("/users")
    Call<UserModel> postUser(@Body UserModel user);

    @PUT("/users/{id}")
    Call<UserModel> putUser(@Body UserModel user, @Path("id") Integer id);

    @DELETE("/users/{id}")
    Call<UserModel> deleteUser(@Path("id") Integer id);
}