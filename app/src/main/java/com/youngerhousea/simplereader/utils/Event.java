package com.youngerhousea.simplereader.utils;


public class Event<T> {
    private final T content;

    public Event(T content) {
        this.content = content;
    }

    private boolean hasBeenHandled = false;
    public T getContentIfNotHandled(){
        if(hasBeenHandled)
            return null;
        else{
            hasBeenHandled = true;
            return content;
        }

    }
}