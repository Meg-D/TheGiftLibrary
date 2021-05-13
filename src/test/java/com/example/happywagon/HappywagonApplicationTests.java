package com.example.happywagon;

import com.example.happywagon.bean.*;
import com.example.happywagon.dao.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HappywagonApplicationTests {


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


    //testing login
    @Test
    public void login(){
        Users u = userDao.findByUsernameEqualsAndPasswordEquals("meghna@gmail.com","admin");
        int check = u.getType();
        Assert.assertNotNull(u);
        Assert.assertEquals(1,check);
        Assert.assertNotEquals(2,check);

        Users u1 = userDao.findByUsernameEqualsAndPasswordEquals("hello@aliciasouza.com","hello");
        int check2 = u1.getType();
        Assert.assertNotNull(u1);
        Assert.assertEquals(2,check2);
        Assert.assertNotEquals(1,check2);

        Users u2 = userDao.findByUsernameEqualsAndPasswordEquals("nope","admin");
        Assert.assertNull(u2);

    }

    //testing artists
    @Test
    public void find_all_Artists(){
        List<Artists> artistsList = artistDao.findAll();
        int num= 4;
        Assert.assertEquals(num,artistsList.size());
    }

    @Test
    public void save_delete_Artist(){
        Artists art = new Artists(5,"Lin Chen","linchen@hello.com","hello","https://www.illustrationx.com/artists/LinChen","+98-76533 33743","Although Lin Chen is fast, efficient and reliable, what her clients love most is the unique visual style she brings to their projects.","photo");
        artistDao.save(art);
        int id=0;
        List<Artists> arts = artistDao.findAll();
        for(int i=0;i<arts.size();i++){
            if(arts.get(i).getArtist_id() == art.getArtist_id()){
                id = arts.get(i).getArtist_id();
//                System.out.println(i);
//                System.out.println(id+"id is this one");
                artistDao.deleteById(arts.get(i).getArtist_id());
                break;
            }
        }
        Assert.assertFalse(artistDao.findById(id).isPresent());
    }

    //testing categories
    @Test
    public void find_all_categories(){
        List<Categories> cateList = categoryDao.findAll();
        int num= 4;
        Assert.assertEquals(num,cateList.size());
    }

    @Test
    public void save_delete_Category(){

        Categories cate = new Categories(5,"demo","for testing","");
        categoryDao.save(cate);
        int id=0;
        List<Categories> cateList = categoryDao.findAll();
        for(int i=0;i<cateList.size();i++){
            if(cateList.get(i).getCategory_id() == cate.getCategory_id()){
                id = cateList.get(i).getCategory_id();
                categoryDao.deleteById(cateList.get(i).getCategory_id());
                break;
            }
        }
        Assert.assertFalse(categoryDao.findById(id).isPresent());
    }

    //testing categoryRequest
    @Test
    public void find_all_categoryRequest(){
        List<Category_Request> cateReqList = categoryRequestDao.findAll();
        int num= 4;
        Assert.assertEquals(num,cateReqList.size());
    }

    @Test
    public void save_delete_CategoryRequest(){
        Category_Request cateReq = new Category_Request(5,"demo","for testing","");
        categoryRequestDao.save(cateReq);
        int id=0;
        List<Category_Request> cateReqList = categoryRequestDao.findAll();
        for(int i=0;i<cateReqList.size();i++){
            if(cateReqList.get(i).getRequest_id() == cateReq.getRequest_id()){
                id = cateReqList.get(i).getRequest_id();
                categoryRequestDao.deleteById(cateReqList.get(i).getRequest_id());
                break;
            }
        }
        Assert.assertFalse(categoryRequestDao.findById(id).isPresent());
    }

    //testing products
    @Test
    public void find_all_Products(){
        List<Products> prodList = productDao.findAll();
        int num= 10;
        Assert.assertEquals(num,prodList.size());
    }

    @Test
    public void save_delete_Product(){
        Categories cate = categoryDao.getOne(1);
        Artists art = artistDao.getOne(1);
        int id=0;
        Products prod = new Products(11,"demo","for testing purpose","Rs30",cate,art,"photo");
        productDao.save(prod);
        List<Products> prodList = productDao.findAll();
        for(int i=0;i<prodList.size();i++){
            if(prodList.get(i).getProduct_id() == prod.getProduct_id()){
                id = prodList.get(i).getProduct_id();
                productDao.deleteById(prodList.get(i).getProduct_id());
                break;
            }
        }
        Assert.assertFalse(productDao.findById(id).isPresent());
    }

}


