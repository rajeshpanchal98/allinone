package org.example;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public class Dll {


    int no;
    Dll next;
    Dll prev;
    Set<String>strings;


    Dll(int no)
    {
        this.no = no;
        next=prev=null;
        strings = new HashSet<>();
    }

}