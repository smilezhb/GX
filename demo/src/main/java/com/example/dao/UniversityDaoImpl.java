package com.example.dao;
import com.example.bean.University;
import com.example.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UniversityDaoImpl {

    public List<University> findAll() {
        SqlSession session = DBUtils.getSqlSession(false);
        List<University> list = session.selectList("findAll");
//        for (University u : list) {
//            System.out.println(u);
//        }
        session.close();
        return list;
    }

    public List<University> findByType(String str) {
        SqlSession session = DBUtils.getSqlSession(false);
        List<University> list = session.selectList("findByType",str);
//        for (University u : list) {
//            System.out.println(u);
//        }
        session.close();
        return list;
    }
    public List<University> findByDistrict(String str) {
        SqlSession session = DBUtils.getSqlSession(false);
        List<University> list = session.selectList("findByDistrict",str);
//        for (University u : list) {
//            System.out.println(u);
//        }
        session.close();
        return list;
    }


    public static void main(String[] args) {
//        UniversityDaoImpl daoImpl = new UniversityDaoImpl();
//        List<University> list = daoImpl.findByType("一流学科");
//        List<University> list1 = daoImpl.findByDistrict("北京市");
//        System.out.println(list1);

    }
}
