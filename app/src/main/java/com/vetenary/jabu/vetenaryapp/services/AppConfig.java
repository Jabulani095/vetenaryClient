package com.vetenary.jabu.vetenaryapp.services;

public class AppConfig {
    public static class APPURL{
        public final static String BASEURL_DEV = "http://ikasideveteas-dev.us-west-2.elasticbeanstalk.com/api/";
    }
    public static  class  ENDPOINT {
        public final static String GET_ALL_APPOINTMENT = "Appointment";
        public final static String GET_APPOINTMENT_BY_ID = "Appointment/";
        public final static String CANCEL_APPOINTMENT = "Appointment";
    }
}
