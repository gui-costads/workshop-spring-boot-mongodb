package com.springmongodb.workshopmongodb.dto;

import com.springmongodb.workshopmongodb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
