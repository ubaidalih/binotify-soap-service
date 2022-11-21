package com;

import javax.xml.ws.Endpoint;

import com.services.*;

public class App 
{
    public static void main( String[] args )
    {
        Endpoint.publish("http://localhost:3060/wbd-soap/subscription", new SubscriptServiceImpl());
    }
}
