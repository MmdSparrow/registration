package ir.blacksparrow.websitebackend.business.comunication.GeoLocation;


import java.util.Locale;

public interface IGeoLocationService {

    Locale getLocaleByIp(String ip);
}
