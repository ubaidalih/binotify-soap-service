package com.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style; 


@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface SubscriptService{
    @WebMethod
    public String createSubscriptDatabase();

    @WebMethod
    public String addSubscript(int creator_id, int subscriber_id);
}