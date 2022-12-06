package com.vungle.warren.tasks;

public interface JobCreator {
    Job create(String str) throws UnknownTagException;
}
