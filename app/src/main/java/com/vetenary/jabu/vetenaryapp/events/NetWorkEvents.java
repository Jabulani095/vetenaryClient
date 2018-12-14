package com.vetenary.jabu.vetenaryapp.events;

public interface NetWorkEvents {
    void OnGetDataSuccess(String responseBody, Object object);
    void OnGetDataFailed(String ResponseBody, Object object,int status);
}
