package com.example.postolache_predescu_sandur_sasu;

import com.example.postolache_predescu_sandur_sasu.model.CartAndHistory;
import com.example.postolache_predescu_sandur_sasu.model.City;
import com.example.postolache_predescu_sandur_sasu.model.Job;
import com.example.postolache_predescu_sandur_sasu.model.Language;
import com.example.postolache_predescu_sandur_sasu.model.Service;
import com.example.postolache_predescu_sandur_sasu.model.Speaks;
import com.example.postolache_predescu_sandur_sasu.model.User;

import java.security.Security;

public class Main {
    public static void main(String[] args) {

        User user = new User(1, "email", "password", "f", "l", "d", "0");
        User user1 = new User(1, "email", "password", "f", "baHCvaKl", "d", "0");

        System.out.println(user);
        System.out.println(user1);

        Job job = new Job("job");
        Job job1 = new Job("job1");

        System.out.println(job);
        System.out.println(job1);

        City city = new City("city");
        System.out.println(city);

        Service service = new Service(job,city,user, 54.20, "description 1", 12, "shadj");
        System.out.println(service);

        Language language = new Language("limba");

        Speaks speaks = new Speaks(user, language);

        System.out.println(speaks);

        CartAndHistory cartAndHistory = new CartAndHistory(user, service, 1, "dhsfhjd");

        System.out.println(cartAndHistory);
    }
}
