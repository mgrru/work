package com.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.example.mapper.WorkerMapper;
import com.example.pojo.Worker;
import com.example.util.Mybatis;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testFindWorkerById() {
        SqlSession sqlSession = Mybatis.getSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = workerMapper.select(1);
        System.out.println(worker);
        sqlSession.close();
    }

    @Test
    public void testAddWorker() {
        SqlSession sqlSession = Mybatis.getSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        Worker worker = new Worker();
        worker.setName("赵六");
        worker.setAge(36);
        worker.setSex("女");
        worker.setWorkerId(1004);
        int num = workerMapper.insert_work(worker);
        if (num > 0) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelWorker() {
        SqlSession sqlSession = Mybatis.getSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        int id = 2;
        int num = workerMapper.del_work(id);
        if (num > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
