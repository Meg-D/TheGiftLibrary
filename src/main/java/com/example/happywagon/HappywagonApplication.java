package com.example.happywagon;

import com.example.happywagon.bean.*;
import com.example.happywagon.dao.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class HappywagonApplication {

    @Autowired
    UserDao userDao;

    @Autowired
    ArtistDao artistDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    CategoryRequestDao categoryRequestDao;

    public static void main(String[] args) {
        SpringApplication.run(HappywagonApplication.class, args);

    }

//    @Bean
//    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//        config.setAllowedMethods(Collections.singletonList("*"));
//        config.setAllowedHeaders(Collections.singletonList("*"));
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter((CorsConfigurationSource) source));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        String url = System.getenv("DATABASE_HOST");
//        if(url !=null){
//            dataSourceBuilder.url("jdbc:mysql://mysql-db-gift:3306/tgl?createDatabaseIfNotExist=true?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
//        }else{
//            dataSourceBuilder.url("jdbc:mysql://localhost:3306/tgl?createDatabaseIfNotExist=true");
//        }
//        dataSourceBuilder.username("tgl");
//        dataSourceBuilder.password("passWord@7");
//        return dataSourceBuilder.build();
//    }

    @Bean
    InitializingBean Users(){
        return () -> {
            userDao.save(new Users("meghna@gmail.com","admin",1));
            userDao.save(new Users("sounak@gmail.com","admin",1));
            userDao.save(new Users("hello@aliciasouza.com","hello",2));
            userDao.save(new Users("hello@aishwarya-vohra-1.com","hello",2));
            userDao.save(new Users("bytatiabaurre@gmail.com","hello",2));
            userDao.save(new Users("hello@illustration.com","hello",2));

            Artists art1 = new Artists(1,"Alicia Souza","hello@aliciasouza.com","hello","https://aliciasouza.com/","+91-72045 56468","Alicia Souza has been drawing since a kid, but unlike many kids, she just never stopped! Expect a constantly changing range with kooky characters and wonky personalities on products that you'd love to have or give!","Alicia-Souza.jpg");
            Artists art2 = new Artists(2,"Aishwarya Vohra","hello@aishwarya-vohra-1.com","hello","https://www.happywagon.com/collections/aishwarya-vohra-1","+91-64465 64321"," am an illustrator and designer from India. I'm a bit of a dreamer and I love to paint whimsical illustrations.","aishwarya-vohra.jpeg");
            Artists art3 = new Artists(3,"Tatiana Abaurre","bytatiabaurre@gmail.com","hello","https://www.tatiabaurre.com/about","+87-76543 87654","An illustrator of everything cute and sweet, Tati wonderfully finds the beauty in the everyday adding a touch of cuteness to everything she creates.","tatiana-abaurre.jpg");
            artistDao.save(art1);
            artistDao.save(art2);
            artistDao.save(art3);
            artistDao.save(new Artists(4,"Gail Armstrong", "hello@illustration.com" ,"hello", "https://www.illustrationx.com/artists/GailArmstrong" , "+91-65432 12345" , "Gail Armstrong has been creating paper sculptures for over 25 years and her enthusiasm for the medium hasn’t waned one snip","gail.jpeg"));

            Categories cat1 = new Categories(1,"Portraits","drawing from a photograph","sample");
            Categories cat2 = new Categories(2,"Greetings","just a card, but with personalized effects","sample4");
            Categories cat3 = new Categories(3,"Infinity Box","box that will go on opening till it vanishes","sample2");
            categoryDao.save(cat1);
            categoryDao.save(cat2);
            categoryDao.save(cat3);
            categoryDao.save(new Categories(4,"Explosion Box","chocolates and memories packed inside a box","sample3"));


            productDao.save(new Products(1,"birthday","cute birthday greeting","Rs120",cat1,art1,"prod1.jpeg"));
            productDao.save(new Products(2,"recipe book","set of 4 recipe books for mom","Rs800",cat1,art2,"prod2.jpg"));
            productDao.save(new Products(3,"surprise box","box containing surprise gifts","Rs240",cat1,art3,"prod3.jpg"));
            productDao.save(new Products(4,"essence","3 bottles of sweet essence","Rs480",cat2,art1,"prod4.jpg"));
            productDao.save(new Products(5,"Greeting card","card of a loved one","Rs99",cat2,art2,"prod5.jpg"));
            productDao.save(new Products(6,"bells","6 bells for decoration","Rs360",cat2,art3,"prod6.jpg"));
            productDao.save(new Products(7,"pebbles","10 customized pebbles","Rs899",cat2,art1,"prod7.jpg"));
            productDao.save(new Products(8,"box","Ice Cream Sundae in a box","Rs560",cat3,art2,"prod8.jpg"));
            productDao.save(new Products(9,"happy jar","jar full of happy notes","Rs233",cat3,art3,"prod9.jpg"));
            productDao.save(new Products(10,"jar","set of 3 sewing jars","Rs720",cat3,art3,"prod10.jpg"));

            categoryRequestDao.save(new Category_Request(1,"light bottles","lights wrapped inside a bottle"));
            categoryRequestDao.save(new Category_Request(2,"photo collage","collage of photos"));
            categoryRequestDao.save(new Category_Request(3,"pillow cover","pillow covers with customized printing"));
            categoryRequestDao.save(new Category_Request(4,"tshirts","tshirts with selected print and color"));

//            artistsRequestDao.save(new Register(1,"Lin Chen","linchen@hello.com","https://www.illustrationx.com/artists/LinChen","+98-76533 33743","Although Lin Chen is fast, efficient and reliable, what her clients love most is the unique visual style she brings to their projects.","photo","hello"));
//            artistsRequestDao.save(new Register(2,"Tim Bradford","timbrad@hello.com","https://www.illustrationx.com/artists/timbradford","+97-65341 33221","From alpine landscapes to geometry and animals, he’s inspired by nature and also loves drawing people of all sizes, shapes and nationalities.","photo2","hello"));
//            artistsRequestDao.save(new Register(3,"Vikcy Scott","vicky1@art.com","https://www.illustrationx.com/artists/VickyScott","+09-87654 42424","Currently based in Sheffield,, Vicky draws inspiration from the natural world, Art Deco architecture, 60s psychedelia and artists like William Morris, Alphons Mucha, Aubrey Beardsley and Henri de Toulouse Lautrec.","photo3","hello"));
//            artistsRequestDao.save(new Register(4,"Fioana Fernandes","fioana@artist.com","https://www.illustrationx.com/artists/FionnaFernandes","+98-32234 23732","Fionna Fernandes is a Sydney-based illustrator who enjoys drawing a variety of subject matter: portraits, stickers, landscapes, lifestyle and animals for clients in fashion, editorial, advertising and more.","photo4","hello"));
        };
    }


}
