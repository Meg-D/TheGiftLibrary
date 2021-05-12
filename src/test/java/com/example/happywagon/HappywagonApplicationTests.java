package com.example.happywagon;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.dao.ArtistDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HappywagonApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    ArtistDao artistDao;

    @Test
    public void find_all_Artists(){
        List<Artists> artistsList = artistDao.findAll();
        int num= 4;
        Assert.assertEquals(num,artistsList.size());
    }
}


