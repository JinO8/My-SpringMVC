package com.jin.demo.sss.service;

import com.jin.demo.sss.dao.ResumeDao;
import com.jin.demo.sss.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjin
 */
@Service
public class ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    public List<Resume> getAll() {
        return resumeDao.findAll();
    }
    public Resume add(Resume resume) {
        return resumeDao.save(resume);
    }
    public Resume update(Resume resume) {
        return resumeDao.save(resume);
    }
    public void delete(Resume resume) {
        resumeDao.delete(resume);
    }
    public Resume getById(Long id) {
        Resume resume = new Resume();
        resume.setId(id);
        Example<Resume> example = Example.of(resume);
        return resumeDao.findOne(example).get();
    }
}
