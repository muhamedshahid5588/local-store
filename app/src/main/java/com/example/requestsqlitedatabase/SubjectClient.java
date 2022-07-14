package com.example.requestsqlitedatabase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SubjectClient {

    @POST("GetSubjectMasters")
    Call<Subject>createSubject(@Body Subject subject);

}
