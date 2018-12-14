package com.vetenary.jabu.vetenaryapp.serializers;

public class DeleteViewModel {
    public String id;

    public DeleteViewModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
