package com.example.services;

import com.example.model.Group;
import com.example.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService implements IGroupService{

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllPersons() {
        List<Group> persons = new ArrayList<Group>();
        groupRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Group getPersonById(long id) {
        return groupRepository.findById(id).get();
    }

    public void saveOrUpdate(Group person) {
        groupRepository.save(person);
    }

    public void delete(long id) {
        groupRepository.deleteById(id);
    }





}
