package com.example.demo;

import com.example.bean.University;
import com.example.dao.UniversityDaoImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Application {

    UniversityDaoImpl dao = new UniversityDaoImpl();

    @GetMapping("/findAll")
    @CrossOrigin(origins = "*")
    public List<University> findAll() {
        System.out.println("findAll");
        List<University> list = dao.findAll();

        return list;

    }

    @GetMapping("/findByType")
    @CrossOrigin(origins = "*")
    public List<University> findByType(String type) {
        System.out.println(type);
        List<University> list = dao.findByType(type);

        return list;
    }

    @GetMapping("/findByDistrict")
    @CrossOrigin(origins = "*")
    public List<University> findByDistrict(String district) {
        System.out.println(district);
        List<University> list = dao.findByDistrict(district);
        System.out.println(list);
        return list;
    }


}