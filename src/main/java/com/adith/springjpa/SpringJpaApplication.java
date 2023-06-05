package com.adith.springjpa;

import com.adith.springjpa.entities.User;
import com.adith.springjpa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class SpringJpaApplication {

            SpringJpaApplication(User user){
                user2=user;
    }
     static User user2;

    public static void main(String[] args) {
//        ConfigurableApplicationContext

        ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        UserRepo userRepo = context.getBean(UserRepo.class);






       // CRUD
        //adding data
        //create Object  User
      /*  User user1 = new User();
        user1.setName("Adith");
        user1.setCity("Bangalore");
        user1.setStatus("Spring Boot Developer");
//        User user1=userRepo.save(user);
//        System.out.println(user1);


        user2.setName("Hari");
        user2.setCity("Gurgaon");
        user2.setStatus("Spring Boot Developer");
        Iterable<User> users = userRepo.saveAll(List.of(user1, user2));

        users.forEach(
            System.out::println
        );
        //we have rto update the user
        //with id
        Optional<User> userss=userRepo.findById(302);
        if(userss.isPresent()){
            User user=userss.get();
            System.out.println(user);
            user.setName("Adith Kalathrakkal");
            System.out.println(userRepo.save(user));
        }
*/
        Iterable<User> itr=userRepo.findAll();

        Iterator<User> iterator=itr.iterator();

        /*while(iterator.hasNext()){
            User user=iterator.next();
            System.out.println(user);
        }*/

       /* for(User user:itr){
            System.out.println(user);
        }*/

       /* itr.forEach(new Consumer<User>(){

            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });*/
        itr.forEach(System.out::println);

        Optional<User> optional=userRepo.findById(303);

//       if(optional.isPresent()) {
//           userRepo.delete(optional.get());
//       }

        System.out.println("user found out");

        System.out.println(userRepo.findUserByName("Adith"));

//        optional.ifPresent(userRepo::delete);

//        userRepo.deleteById(302);

        System.out.println("city user");

//        System.out.println(userRepo.findUserByCity("Gurgaon"));
        List<User>users=userRepo.findUserByCity("Gurgaon");
        users.forEach(System.out::println);

        List<User>usq=userRepo.findUserByNameAndCity("Adith","Bangalore");
        System.out.println("city and name user");

        for(User s: usq) System.out.println(s);


    }

}
